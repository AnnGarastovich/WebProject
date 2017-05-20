package servlet;

/**
 * Created by Ann on 19.05.2017.
 */
import launch.BD_ListOfFood;
import launch.BD_ListOfTrainings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(
        name = "AddTrenirovkiServlet",
        urlPatterns = {"/TrenirovkiAdd"}
)

public class AddTrenirovkiServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BD_ListOfTrainings TR=new BD_ListOfTrainings();
        TR.Name=request.getParameter("trenirovkaname");
        TR.AmountOfCaloriesBurnedIn10min=Integer.parseInt(request.getParameter("kolkalburned"));
        BD_ListOfTrainings L=new BD_ListOfTrainings();
        int result=0;
        result = L.Add_DanListOfTrainings(TR.Name, TR.AmountOfCaloriesBurnedIn10min);
        List<BD_ListOfTrainings> h=new ArrayList();
        BD_ListOfTrainings list=new BD_ListOfTrainings();
        h=list.Look_ListOfTrainings();
        request.setAttribute("Name",h);
        String st=new String();

        if(result==0 || TR.Name.equals(st) || TR.AmountOfCaloriesBurnedIn10min==0)
        {
            request.getRequestDispatcher("/AddTrenirovkiForm.jsp").forward(request, response);
        }
      else   request.getRequestDispatcher("/Trenirovki.jsp").forward(request, response);
    }

}
