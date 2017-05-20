package servlet;

/**
 * Created by Ann on 19.05.2017.
 */

import launch.BD_ListOfFood;
import launch.BD_User;
import launch.BD_WaterBalance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "ProfilServlet",
        urlPatterns = {"/Profil"}
)
public class ProfilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BD_WaterBalance W = new BD_WaterBalance();
        W.Id_user = (Integer) request.getSession().getAttribute("Id_user");

        request.getRequestDispatcher("/Profil.jsp").forward(request, response);
    }
}
