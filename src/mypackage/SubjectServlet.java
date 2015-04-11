package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by sergei on 05.04.2015.
 */

public class SubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Main main = new Main();
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            req.setAttribute("subj", main.getSubjects(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/subjects.jsp");
        dispatcher.forward(req,resp);

    }
}
