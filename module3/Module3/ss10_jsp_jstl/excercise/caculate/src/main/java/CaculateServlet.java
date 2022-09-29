import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CaculateServlet", urlPatterns = "/result")
public class CaculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOpera = Float.parseFloat(request.getParameter("first-opera"));
        float secondOpera = Float.parseFloat(request.getParameter("second-opera"));
        String operator = request.getParameter("operator");
        request.setAttribute("firstOpera", firstOpera);
        request.setAttribute("secondOpera", secondOpera);
        request.setAttribute("operator", operator);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
