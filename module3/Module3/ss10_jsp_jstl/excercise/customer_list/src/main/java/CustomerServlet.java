import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("1", "Nguyễn Duy Quang", "1994-01-01", "Huế", "img/anhquang.jpg"));
        customerList.add(new Customer("2", "Hoàng Giang", "1994-01-01", "Đà Nẵng", "img/anhgiang.jpg"));
        customerList.add(new Customer("3", "Minh Châu", "2000-01-01", "Đà Nẵng", "img/bechau.jpg"));
        customerList.add(new Customer("4", "Đức Uy", "2000-01-01", "Đà Nẵng", "img/thanguy.jpg"));
        customerList.add(new Customer("5", "Giang Ca", "1994-01-01", "Đà Nẵng", "img/anhgiang.jpg"));

        request.setAttribute("customerListServlet", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
