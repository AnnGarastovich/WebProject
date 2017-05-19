package servlet;

import javax.servlet.annotation.WebServlet;
import launch.BD_ListOfFood;
import launch.BD_ListOfTrainings;
import launch.BD_User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
BD_ListOfFood D= new BD_ListOfFood();
//D.Name=request.getParameter("foodname");
//D.AmountOfCaloriesIn100gr=Integer.parseInt(request.getParameter("kolkal"));
     //   System.out.println(D.Name);
       // System.out.println(D.AmountOfCaloriesIn100gr);
        String Sr=new String();
        int ch=0;
       // List<BD_ListOfFood>  h=new ArrayList();
      //  BD_ListOfFood list=new BD_ListOfFood();
       // h=list.Look_ListOfFood();
       // request.setAttribute("Name",h);

        if(/*D.Name.equals(Sr) || D.AmountOfCaloriesIn100gr==0*/ ch!=0)
        {
            request.getRequestDispatcher("/AddFoodForm.jsp").forward(request, response);
        }
       else  request.getRequestDispatcher("/Menu.jsp").forward(request, response);
    }

}
