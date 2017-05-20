package servlet;

/**
 * Created by Ann on 19.05.2017.
 */
import launch.BD_ListOfFood;
import launch.BD_WaterBalance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebServlet(
        name = "AddWaterServlet",
        urlPatterns = {"/DnevnikWaterAdd"}
)
public class DnevnikWaterAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date date=new Date();
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("Data", data.format(date));

        BD_WaterBalance W=new BD_WaterBalance();
        W.AmountOfDrinks=Integer.parseInt(request.getParameter("kolwater"));
        BD_WaterBalance Obj=new BD_WaterBalance();
        W.Id_user = (Integer) request.getSession().getAttribute("Id_user");
Obj.Add_DanWater(W.AmountOfDrinks,W.Id_user);



        request.getRequestDispatcher("/Dnevnik.jsp").forward(request, response);
    }




}
