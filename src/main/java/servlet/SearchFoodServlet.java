package servlet;

/**
 * Created by Ann on 20.05.2017.
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
        name = "SearchFoodServlet",
        urlPatterns = {"/MenuSearch"}
)
public class SearchFoodServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BD_ListOfFood FD=new BD_ListOfFood();
        FD.Name=request.getParameter("searchfood");
        List<BD_ListOfFood> h=new ArrayList();
        BD_ListOfFood listA=new BD_ListOfFood();
        h=listA.Search_Food(FD.Name);
        request.setAttribute("Name",h);

        request.getRequestDispatcher("/Menu.jsp").forward(request, response);
    }

}
