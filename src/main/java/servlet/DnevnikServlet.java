package servlet;

import launch.BD_ListOfFood;
import launch.BD_ListOfTrainings;
import launch.BD_User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "DnevnikServlet",
        urlPatterns = {"/Dnevnik"}
)
public class DnevnikServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Date date=new Date();
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("Data", data.format(date));

        request.getRequestDispatcher("/Dnevnik.jsp").forward(request, response);

    }



}
