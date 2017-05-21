package servlet;

/**
 * Created by Ann on 21.05.2017.
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
        name = "SearchTrainingServlet",
        urlPatterns = {"/TrenirovkiSearch"}
)
public class SearchTrainingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BD_ListOfTrainings FD=new BD_ListOfTrainings();
        FD.Name=request.getParameter("searchtrenirovki");
        List<BD_ListOfTrainings> h=new ArrayList();
        BD_ListOfTrainings listA=new BD_ListOfTrainings();
        h=listA.Search_Training(FD.Name);
        request.setAttribute("Name",h);

        request.getRequestDispatcher("/Trenirovki.jsp").forward(request, response);
    }
}
