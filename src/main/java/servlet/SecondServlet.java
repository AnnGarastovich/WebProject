package servlet;

import launch.BD_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ann on 01.05.2017.
 */
@WebServlet(
        name = "SecondServlet",
        urlPatterns = {"/main"}
)
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<BD_User> g= new ArrayList();

        BD_User list=new BD_User();


      g=list.Look_User();


        request.setAttribute("Name",g);
     String  f= request.getParameter("text_name");
        request.setAttribute("TestName", f);


        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

}
