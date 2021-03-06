package servlet;

/**
 * Created by Ann on 19.05.2017.
 */
import launch.BD_ListOfFood;
import launch.BD_UserFood;
import launch.BD_UserTrainings;
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

        List<BD_WaterBalance> hi=new ArrayList();
        BD_WaterBalance list=new BD_WaterBalance();
        int Id_user;
        Id_user = (Integer) request.getSession().getAttribute("Id_user");
        hi=list.Look_WaterBalance(Id_user);
        request.setAttribute("Name",hi);
        List<BD_UserFood> u=new ArrayList();
        BD_UserFood listU=new BD_UserFood();
        int Id_userU;
        Id_userU = (Integer) request.getSession().getAttribute("Id_user");
        u=listU.Look_UserFood(Id_userU);
        request.setAttribute("NameUser",u);
        List<BD_UserTrainings> t=new ArrayList();
        BD_UserTrainings listT=new BD_UserTrainings();
        int Id_userT;
        Id_userT = (Integer) request.getSession().getAttribute("Id_user");
        t=listT.Look_UserTrainings(Id_userT);
        request.setAttribute("NameTraining",t);

        request.getRequestDispatcher("/Dnevnik.jsp").forward(request, response);
    }




}
