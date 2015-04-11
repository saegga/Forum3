package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sergei on 14.03.2015.
 */
//@WebServlet("/authorisation")
@WebServlet(urlPatterns = "/login")
public class Authentication extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ResultSet rs;
        String userName;
        String password;

        try {

            ConnectJDBC connection = new ConnectJDBC();
            Connection currentConnection = connection.getConnection();
            Statement statement = currentConnection.createStatement();
            Main main = new Main();
            rs = main.getAllUsers();

            boolean flag = false;
            String tempName = req.getParameter("name");
            String tempPassword = req.getParameter("password");

            while (rs.next()) {
                userName = rs.getString("name");
                password = rs.getString("password");

                if (tempName.equals(userName) &&
                        tempPassword.equals(password)) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("flag", true);
                    session.setAttribute("email", rs.getString("email"));
                    session.setAttribute("currentId", rs.getInt("id"));
                    resp.sendRedirect("index");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                String nextJSP = "/error.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.forward(req, resp);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
