package servlet;

import launch.BD_ListOfFood;
import launch.BD_User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/ProfilAVT"}
)
public class ProfilAfterVhodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BD_User obj = new BD_User();
        obj.login = request.getParameter("login");
        obj.password = request.getParameter("password");

        System.out.println(obj.password);
        BD_User g = new BD_User();
        int id_user = 0;
        try {
            id_user = g.AVT(obj.login, obj.password);
            request.getSession().setAttribute("Id_user", id_user);
            System.out.println(id_user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (id_user == 0) {
            request.getRequestDispatcher("/Vhod.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/Profil");
            rd.forward(request, response);
        }
    }
}
