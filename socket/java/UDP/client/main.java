import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class main {
    static String HOST = "localhost";
    static int    PORT = 8080;
    public static void main(String args[]) throws Exception {
        DatagramSocket sock = new DatagramSocket();
        InetAddress host = InetAddress.getByName(HOST);
        int n = 100000;
        for (int i = 0; i < n; ++i) {
            byte[] mess = ("Hello, World! " + i).getBytes();
            DatagramPacket data = new DatagramPacket(mess, mess.length, host, PORT);
            sock.send(data);
        }
        byte[] mess = "Goodbye".getBytes();
        DatagramPacket data = new DatagramPacket(mess, mess.length, host, PORT);
        sock.send(data);
        sock.close();
    }
}
