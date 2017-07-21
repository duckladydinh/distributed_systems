import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class main {
    static String HOST = "localhost";
    static int    PORT = 8080;
    public static void main(String[] args) throws Exception {
        ServerSocket spy = new ServerSocket(PORT);
        Socket sock = spy.accept();
        DataInputStream  in  = new DataInputStream(sock.getInputStream());
        DataOutputStream out = new DataOutputStream(sock.getOutputStream());
        int N = 0;
        while (true) {
            String mess = in.readUTF();
            if (mess.equals("Goodbye")) {
                break;
            }
            N += 1;
        }
        System.out.println("Received " + N + " line(s)");
        sock.close();
        spy.close();
    }
}
