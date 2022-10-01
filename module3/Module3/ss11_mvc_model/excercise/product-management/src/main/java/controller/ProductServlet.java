package controller;

import model.Product;
import org.omg.PortableInterceptor.INACTIVE;
import service.IProductService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "find":
                find(request, response);
                break;
            default:

        }

    }

    private void find(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> products = this.productService.findByName(name);
        if (products.size() == 0) {
            request.setAttribute("message", "Không tìm thấy");
            try {
                request.getRequestDispatcher("product/find.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("products", products);
            try {
                request.getRequestDispatcher("product/find.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String attribute = request.getParameter("attribute");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = this.productService.findById(id);
        product.setName(name);
        product.setAttribute(attribute);
        product.setPrice(price);
        this.productService.update(productService.findAll().indexOf(product), product);
        request.setAttribute("product", product);
        request.setAttribute("message", "Sửa thành công");
        try {
            request.getRequestDispatcher("product/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showEditForm(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.productService.remove(product);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void create(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String attribute = request.getParameter("attribute");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(id, name, attribute, price);
        this.productService.save(product);
        request.setAttribute("message", "Thêm mới thành công");
        try {
            request.getRequestDispatcher("product/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showCreateForm(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }


    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("product/view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("product/delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = this.productService.findById(id);
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("productList", productService.findAll());
        try {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
