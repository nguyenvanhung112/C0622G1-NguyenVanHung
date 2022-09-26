import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "ProductServlet",value = "/display-discount")
public class ProductServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String description = request.getParameter("ProductDescription");
        double price = Double.parseDouble(request.getParameter("ListPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("DiscountPercent"));
        double discount = price * discountPercent * 0.01;
        request.setAttribute("description",description);
        request.setAttribute("price",price);
        request.setAttribute("discountPercent",discountPercent);
        request.setAttribute("discount",discount);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
