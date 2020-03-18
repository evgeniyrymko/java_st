package ex_004_params;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Asus on 29.01.2018.
 */
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req, resp);
    }

    private void proccessRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        String param2 = req.getParameter("p2");

        Enumeration<String> allParams = req.getParameterNames();

        try {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>");
            writer.println("second servlet");
            writer.println("</title>");
            writer.println("</head>");
            writer.println("<body>");

            int i = 1;

            while (allParams.hasMoreElements()) {
                writer.print("<p>");
                String param = allParams.nextElement();
                String value = req.getParameter(param);
                writer.println("param " + i + " " + param + " = " + value);
                writer.print("</p>");
                i++;
            }

            writer.println("</body");
            writer.println("</html>");
        } finally {
            writer.close();
        }

    }

}
