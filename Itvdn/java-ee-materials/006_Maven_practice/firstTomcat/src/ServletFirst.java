import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Asus on 05.02.2018.
 */
public class ServletFirst extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>Hello</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h2>Hello Java from Tomcat</h2>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
