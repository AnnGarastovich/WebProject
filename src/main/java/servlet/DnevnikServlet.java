package servlet;

import launch.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<BD_WaterBalance> h=new ArrayList();
        BD_WaterBalance list=new BD_WaterBalance();
        int Id_user;
        Id_user = (Integer) request.getSession().getAttribute("Id_user");
        h=list.Look_WaterBalance(Id_user);
        request.setAttribute("Name",h);
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
