package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ann on 21.05.2017.
 */
@WebServlet(
        name = "AddUserFoodFormServlet",
        urlPatterns = {"/AddUserFoodForm"}
)
public class AddUserFoodForm extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.getRequestDispatcher("/AddUserFood.jsp").forward(request, response);
    }
}
