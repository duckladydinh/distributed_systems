import org.BOOK;

import java.rmi.Naming;
import java.util.Scanner;

public class clientA {
    public static void main(String[] args) throws Exception {
        BOOK book = (BOOK) Naming.lookup("book");
        book.show();
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.next();
            if (line.equals("show")) {
                book.show();
            } else {
                book.add(line);
            }
        }
    }
}
