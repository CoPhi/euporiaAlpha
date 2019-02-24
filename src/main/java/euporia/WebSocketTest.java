package euporia;

import euporia.json.Message;
import euporia.json.MessageDecoder;
import euporia.json.MessageEncoder;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/wstest", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class WebSocketTest {

    private static ConcurrentHashMap<String, Session> connMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException {
        // add user in the HashMap with this session as value
        connMap.put(username, session);
        session.getBasicRemote().sendText("{\"success\": \"connected\"}");
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException {
        // When we get a message, we take all stored sessions and send them this message
        // All users will thus get this message, including the one sending it.
        // This is just for testing
        connMap.values().forEach(s -> {
            try {
                s.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }

    @OnClose
    public void onClose(Session session) throws IOException {
       // TODO remove this session from the active ones
    }
}