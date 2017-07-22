import org.BOOK;
import org.Book;

import java.rmi.Naming;

public class server {
    public static void main(String[] args) throws Exception {
        BOOK book = new Book();
        Naming.rebind("book", book);
        System.out.println("\t...SERVER STARTED...");
    }
}
