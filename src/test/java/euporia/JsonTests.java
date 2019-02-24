package euporia;

import com.google.gson.Gson;
import euporia.json.Message;
import euporia.json.MessageDecoder;
import euporia.json.MessageEncoder;
import euporia.json.User;
import junit.framework.TestCase;

import javax.websocket.DecodeException;
import javax.websocket.EncodeException;

public class JsonTests extends TestCase {
    private String userJson = "{\"username\":\"username\",\"firstName\":\"mario\",\"lastName\":\"rossi\"}";
    private String msgJson = String.format("{\"from\":%s,\"content\":\"ciao\"}", userJson);

    public void testUserDecoder() {
        User user = new Gson().fromJson(userJson, User.class);
        assertEquals(user.getUsername(), "username");
        assertEquals(user.getFirstName(), "mario");
        assertEquals(user.getLastName(), "rossi");
    }

    public void testUserEncoder() {
        User u = new User("username", "mario", "rossi");
        String s = new Gson().toJson(u);
        assertEquals(s, userJson.trim());
    }

    public void testMessageDecoder() {
        try {
            MessageDecoder dec = new MessageDecoder();
            Message message = dec.decode(msgJson);
            assertEquals(message.getFrom().getFirstName(), "mario");
            assertEquals(message.getFrom().getLastName(), "rossi");
            assertEquals(message.getFrom().getUsername(), "username");
            assertEquals(message.getContent(), "ciao");
        } catch (DecodeException e) {
            fail(e.getText());
        }
    }

    public void testMessageEncoder() {
        Message m = new Message(new User("username", "mario", "rossi"), "ciao");
        try {
            String s = new MessageEncoder().encode(m);
            assertEquals(s, msgJson);
        } catch (EncodeException e) {
            fail(e.getMessage());
        }
    }
}
