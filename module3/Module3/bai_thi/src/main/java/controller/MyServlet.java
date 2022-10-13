package controller;

import model.Sanpham;
import service.IService;
import service.SanphamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MyServlet" , urlPatterns = "/sanpham")
public class MyServlet extends HttpServlet {
    private IService service = new SanphamService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(request, response);
                break;
            default:
                list(request, response);
                break;
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten");
        double gia = Double.parseDouble(request.getParameter("gia"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String mausac = request.getParameter("mausac");
        String mota = request.getParameter("mota");
        int danhmuc = Integer.parseInt(request.getParameter("danhmuc"));
        Sanpham newSanpham = new Sanpham(ten,gia,soluong,mausac,mota,danhmuc);
        boolean check = service.add(newSanpham);
        request.setAttribute("mess","Thêm thành công!");
        if (!check){
            request.setAttribute("mess","Thêm không thành công!");
            try {
                request.getRequestDispatcher("view/add.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            request.getRequestDispatcher("view/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showForm(request, response);
                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
            case "delete":
                deleteSanpham(request, response);
                break;
            case "find":
                find(request,response);
                break;
            default:
                list(request, response);
                break;
        }
    }

    private void find(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten");
            List<Sanpham> sanphamList = service.findTen(ten);
            request.setAttribute("sanphamList",sanphamList);
            try {
                request.getRequestDispatcher("view/list.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void deleteSanpham(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        list(request,response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/add.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) {
        List<Sanpham> sanphams = service.getList();
        request.setAttribute("sanphamList",sanphams);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
