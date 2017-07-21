import java.net.*;

public class main {
    static String HOST = "localhost";
    static int    PORT = 8080;
    public static void main(String[] args) throws Exception {
        DatagramSocket sock = new DatagramSocket(PORT);
        int    N      = 0;
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket data = new DatagramPacket(buffer, buffer.length);
            sock.receive(data);
            String mess = new String(data.getData(), "UTF-8");
            mess = mess.trim();
            if (mess.equals("Goodbye")) {
                break;
            }
            N += 1;
        }
        sock.close();
        System.out.println("Received " + N + " line(s)");
    }
}
