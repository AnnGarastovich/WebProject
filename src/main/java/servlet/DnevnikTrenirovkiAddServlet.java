package servlet;

import launch.*;

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
        name = "DnevnikAddUserTrenirovkiServlet",
        urlPatterns = {"/DnevnikAddUserTraining"}
)
public class DnevnikTrenirovkiAddServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date date=new Date();
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("Data", data.format(date));

        BD_UserTrainings W=new BD_UserTrainings();
        String name= new String();
        name=request.getParameter("usertrenirovkaname");
        BD_UserTrainings BD=new BD_UserTrainings();
        List<BD_ListOfTrainings> h=new ArrayList();
        BD_ListOfTrainings listA=new BD_ListOfTrainings();
        h=listA.Search_Training(name);
        int Id_food=0;
        BD_ListOfTrainings L=new BD_ListOfTrainings();
        L=h.get(0);
        Id_food=L.Id_training;
        W.AmountOfMinute=Integer.parseInt(request.getParameter("userkolkalburned"));
        W.Id_user = (Integer) request.getSession().getAttribute("Id_user");
        BD_ListOfTrainings lIST=new BD_ListOfTrainings();
        int result=0;
        result= BD.Add_DanUserTrainings(W.AmountOfMinute,(L.AmountOfCaloriesBurnedIn10min*W.AmountOfMinute)/10, L.Id_training, W.Id_user);
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
