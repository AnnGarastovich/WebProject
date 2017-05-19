package servlet;

import launch.BD_ListOfFood;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ann on 16.05.2017.
 */
@WebServlet(
        name = "AddFoodServlet",
        urlPatterns = {"/MenuAdd"}
)
public class AddFoodServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BD_ListOfFood D= new BD_ListOfFood();
D.Name=request.getParameter("foodname");
D.AmountOfCaloriesIn100gr=Integer.parseInt(request.getParameter("kolkal"));
          System.out.println(D.Name);
        System.out.println(D.AmountOfCaloriesIn100gr);
      //  List<BD_ListOfFood> h=new ArrayList();
       //   BD_ListOfFood list=new BD_ListOfFood();
      //  h=list.Look_ListOfFood();
      //  request.setAttribute("Name",h);


        request.getRequestDispatcher("/Menu.jsp").forward(request, response);
    }

    }
