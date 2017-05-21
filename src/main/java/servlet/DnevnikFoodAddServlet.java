package servlet;

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

/**
 * Created by Ann on 21.05.2017.
 */
@WebServlet(
        name = "DnevnikAddUserFoodServlet",
        urlPatterns = {"/DnevnikAddUserFood"}
)
public class DnevnikFoodAddServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date date=new Date();
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("Data", data.format(date));

        BD_UserFood W=new BD_UserFood();
        String name= new String();
        name=request.getParameter("userfoodname");
        BD_UserFood BD=new BD_UserFood();
        List<BD_ListOfFood> h=new ArrayList();
        BD_ListOfFood listA=new BD_ListOfFood();
        h=listA.Search_Food(name);
        int Id_food=0;
        BD_ListOfFood L=new BD_ListOfFood();
        L=h.get(0);
        Id_food=L.Id_Food;
        W.QuantityEatenGr=Integer.parseInt(request.getParameter("userkolkal"));
        W.Id_user = (Integer) request.getSession().getAttribute("Id_user");
        BD_ListOfFood lIST=new BD_ListOfFood();
        int result=0;
       result= BD.Add_DanUserFood(W.QuantityEatenGr,(L.AmountOfCaloriesIn100gr*W.QuantityEatenGr)/100, L.Id_Food, W.Id_user);
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
        request.getRequestDispatcher("/Dnevnik.jsp").forward(request, response);}
}
