package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


/**
 * Created by sergei on 10.03.2015.
 */

@WebServlet("/posting")
public class PostServlet extends HttpServlet {
    private final String POSTING = "INSERT INTO posts(dt, user_id, txt, subject_id, reply_to) VALUE(?,?,?,?,?) ";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ConnectJDBC currentConnection = new ConnectJDBC();
        Connection connection = currentConnection.getConnection();

        try {
            Date d = new Date();
            java.sql.Date date = new java.sql.Date(d.getTime());
            PreparedStatement statement = connection.prepareStatement(POSTING);
            String caption = new String(req.getParameter("post").getBytes("ISO-8859-1"), "windows-1252");
            // String caption = req.getParameter("post");
            statement.setDate(1, date);
            statement.setInt(2, (Integer) req.getSession().getAttribute("currentId"));
            statement.setString(3, caption);
            statement.setInt(4, (Integer.parseInt(req.getSession().getAttribute("subj_id").toString())));
            resp.setContentType("text/html;charset=UTF-8");
            statement.setInt(5, 1);//TODO reply сделать как надо
            statement.execute();


            String nextJsp = "/posts.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
