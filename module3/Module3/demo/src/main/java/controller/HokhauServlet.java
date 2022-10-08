package controller;

import model.Hokhau;
import model.Thanhvien;
import service.IHokhauService;
import service.impl.HokhauService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "HokhauServlet",urlPatterns = "/hokhau")
public class HokhauServlet extends HttpServlet {
    IHokhauService hokhauService = new HokhauService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "add":
//                themhokhau(request, response);
//                break;
            case "edit":
                edit(request, response);
                break;
//            case "delete":
//                deleteFacility(request, response);
//                break;
//            case "view":
//                listThanhVien(request,response);
//                break;
            default:
                try {
                    listhokhau(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenchuho = request.getParameter("name");
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String ngaylap = request.getParameter("ngaylap");
        String diachi = request.getParameter("diachi");
        Hokhau hokhau = new Hokhau(id,tenchuho,soluong,ngaylap,diachi);
        hokhauService.update(hokhau);
        try {
            request.getRequestDispatcher("view/themhokhau.jsp").forward(request,response);
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
//            case "add":
//                themhokhau(request, response);
//                break;
            case "edit":
                showEditForm(request, response);
                break;
//            case "delete":
//                deleteFacility(request, response);
//                break;
//            case "view":
//                listThanhVien(request,response);
//                break;
            default:
                try {
                    listhokhau(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Hokhau hokhau = hokhauService.selecthokhau(id);
        request.setAttribute("hokhau",hokhau);
        try {
            request.getRequestDispatcher("view/themhokhau.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void listThanhVien(HttpServletRequest request, HttpServletResponse response) {

//        Map<Integer,List<Thanhvien>> map = hokhauService.getListThanhVien();


        try {
            request.getRequestDispatcher("view/view.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listhokhau(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Hokhau> hokhauList = hokhauService.getListHoKhau();
        Map<Integer,List<Thanhvien>> map = hokhauService.getListThanhVienmap();
        request.setAttribute("hokhauList",hokhauList);
        request.setAttribute("map",map);
        try {
            request.getRequestDispatcher("view/hokhau.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
