import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

@WebServlet("/compute")
public class brain extends HttpServlet {
    public long fib(long n) {
        long a = 0, b = 1, c = 1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        for (int i = 2; i <= n; ++i) {
            a = b; b = c; c = a + b;
        }
        return c;
    }

    public void service(HttpServletRequest in, HttpServletResponse out)
            throws IOException, ServletException {
        long n = -1;
        if (in.getParameter("number") != null) {
            n = Long.parseLong(in.getParameter("number"));
        }

        String user = null;
        if (in.getParameter("username") != null) {
            user = in.getParameter("username");
            if (in.getSession().getAttribute(user) == null) {
                in.getSession().setAttribute(user, new ArrayList<Long>());
            }
        }
        ArrayList<Long> numbers = new ArrayList<>();
        if (user != null) {
            numbers = (ArrayList<Long>)in.getSession().getAttribute(user);
        }
        if (n >= 0) {
            numbers.add(n);
        }
        URL url = new URL("http://localhost:8080/fib.html");
        Scanner inner = new Scanner(new InputStreamReader(url.openStream()));
        PrintWriter outer = out.getWriter();
        while (inner.hasNextLine()) {
            String line = inner.nextLine();
            if (line.contains("</form>")) {
                outer.println("<h5 class=\"display-1 text-center text-success\"> "
                        + (n >= 0? ("Result is " + fib(n)) : "")
                        + "</h5>"
                );
                for (Long v: numbers) {
                    outer.println(v + " ");
                }
                outer.println("<br>");
            }
            outer.println(line);
        }
    }
}





