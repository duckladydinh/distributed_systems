import org.Book;

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
        ObjectInputStream in  = new ObjectInputStream(sock.getInputStream());

        ArrayList<Book> books = (ArrayList<Book>) in.readObject();
        for (Book book: books) {
            book.show();
        }
        sock.close();
        spy.close();
    }
}
