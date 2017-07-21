import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class main {
    static String HOST = "localhost";
    static int    PORT = 8080;
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket(HOST, PORT);
        DataInputStream in = new DataInputStream(sock.getInputStream());
        DataOutputStream out = new DataOutputStream(sock.getOutputStream());
        int n = 100000;
        for (int i = 0; i < n; ++i) {
            out.writeUTF("Hello World " + i);
            out.flush();
        }
        out.writeUTF("Goodbye");
        out.flush();
        sock.close();
    }
}
