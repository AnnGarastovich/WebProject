package servlet;

import launch.BD_User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/Profil"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BD_User obj=new BD_User();
        obj.login=request.getParameter("login");
        obj.password=request.getParameter("password");
        System.out.println(obj.login);
        System.out.println(obj.password);

        request.getRequestDispatcher("/Profil.jsp").forward(request, response);
    }

    
}
