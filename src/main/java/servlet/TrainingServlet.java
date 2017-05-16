package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ann on 16.05.2017.
 */

@WebServlet(
        name = "TrainingServlet",
        urlPatterns = {"/Trenirovki"}
)
public class TrainingServlet extends HttpServlet {
    int ch=0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(/*D.Name.equals(Sr) || D.AmountOfCaloriesIn100gr==0*/ ch!=0)
        {
            request.getRequestDispatcher("/AddTrenirovkiForm.jsp").forward(request, response);
        }
        else  request.getRequestDispatcher("/Trenirovki.jsp").forward(request, response);
    }
    }
