package servlet;

import javax.servlet.annotation.WebServlet;
import launch.BD_ListOfFood;
import launch.BD_ListOfTrainings;
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
/**
 * Created by Ann on 15.05.2017.
 */

@WebServlet(
        name = "MenuServlet",
        urlPatterns = {"/Menu"}
)
public class MenuServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.getRequestDispatcher("/Menu.jsp").forward(request, response);
    }

}
