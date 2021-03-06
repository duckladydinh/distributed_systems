import org.Book;
import org.Page;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class client {
    static String HOST = "localhost";
    static int    PORT = 8080;
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket(HOST, PORT);
        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());

        int n = 2;
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            Book book = new Book("Book No. " + i);
            for (int j = 0; j < 10; ++j) {
                Page page = new Page("I am page No. " + j + " of " + book.name);
                book.add(page);
            }
            books.add(book);
        }
        out.writeObject(books);
        out.flush();
        sock.close();
    }
}
