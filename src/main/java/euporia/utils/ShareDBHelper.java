package euporia.utils;

import euporia.database.documents.Blocks;
import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

public class ShareDBHelper {
    public static final String SHAREDB_URL = "";

    public static boolean sendBlock(Blocks block) {
        try {
            byte[] encodedText = Base64.getEncoder().encode(compressText(block.getContent()));
            String json = String.format("{\"docId\": %d, \"docText\": \"%s\"}", block.getId(), Arrays.toString(encodedText));
            URL url = new URL(SHAREDB_URL);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            // This is also used to set headers apparently
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.close();

            return conn.getResponseCode() == 200;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] compressText(String text) throws IOException{
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        GZIPOutputStream gzipOs = new GZIPOutputStream(buffer);
        byte[] content = text.getBytes();
        gzipOs.write(content, 0, content.length);
        gzipOs.close();
        return buffer.toByteArray();
    }
}

