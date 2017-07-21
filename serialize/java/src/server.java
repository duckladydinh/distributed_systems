import org.Book;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {
    static String HOST = "localhost";
    static int    PORT = 8080;
    public static void main(String[] args) throws Exception {

        ServerSocket spy = new ServerSocket(PORT);
        Socket sock = spy.accept();
        DataInputStream  in  = new DataInputStream(sock.getInputStream());
        DataOutputStream out = new DataOutputStream(sock.getOutputStream());

        ObjectInputStream in_wrapper = new ObjectInputStream(in);
        ArrayList<Book> books = (ArrayList<Book>) in_wrapper.readObject();
        for (Book book: books) {
            book.show();
        }
        sock.close();
        spy.close();
    }
}
