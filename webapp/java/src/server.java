import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet("/login")
public class server extends HttpServlet {
    public void service(HttpServletRequest in, HttpServletResponse out)
            throws IOException, ServletException {
        Enumeration<String> paras = in.getParameterNames();
        String user = null;
//        out.getWriter().println("Hello World");
        if (in.getParameter("username") != null) {
            user = in.getParameter("username");
        }
        if (user == null) {
            out.sendRedirect("/compute");
        } else {
            out.sendRedirect("/compute?username=" + user);
        }
    }
}
