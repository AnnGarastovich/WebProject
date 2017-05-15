package servlet;

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

@WebServlet(
        name = "MainServlet",
        urlPatterns = {"/Vhod"}
)
public class MainServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
/*BD_User Obj=new BD_User();
Obj.CREATE_TABLE_User();
Obj.name=request.getParameter("name");
Obj.login=request.getParameter("reglogin");
Obj.password=request.getParameter("regpassword");
Obj.age=Integer.parseInt(request.getParameter("age"));
Obj.weight = Integer.parseInt(request.getParameter("weight"));
Obj.height=Integer.parseInt(request.getParameter("height"));
        System.out.println(Obj.name);
        System.out.println(Obj.login);
        System.out.println(Obj.password);
        System.out.println(Obj.age);
        System.out.println(Obj.weight);
        System.out.println(Obj.height);
        String s=new String();*/
        int y=0;
        if(/*s.equals(Obj.name) || s.equals(Obj.login) || s.equals(Obj.password) || y==Obj.age || y==Obj.weight || y==Obj.height*/y==1 )
        {
            request.getRequestDispatcher("/Registration.jsp").forward(request, response);
        }
else {

BD_User Fun=new BD_User();
int u=0;

            //u=Fun.Add_User(Obj.name, Obj.login, Obj.password, Obj.age, Obj.weight, Obj.height) ;

request.getRequestDispatcher("/Vhod.jsp").forward(request, response);
    }}

}
