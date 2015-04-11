package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.io.IOException;

/**
 * Created by sergei on 15.03.2015.
 */
@WebServlet("/reg")
public class Registration extends HttpServlet {
    int idRegistration;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Main main = new Main();
        ConnectJDBC connection = new ConnectJDBC();
        Connection currentConnection = connection.getConnection();
        Users user = new Users();

        if (connection.checkRegistration(currentConnection, req)) {
            String nextJSP = "/errorRegistration.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(req, resp);
        }
        try {
            //user = new Users();
            user.setName(req.getParameter("log"));
            user.setEmail(req.getParameter("mail"));
            user.setPassword(Integer.parseInt(req.getParameter("pasw")));
            main.insertNewUser(user);
            idRegistration = main.getIdSession();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("flag", true);
        session.setAttribute("email", req.getParameter("mail"));
        session.setAttribute("currentId", idRegistration);

        SendMail sendMail = new SendMail();
        sendMail.sendMail(user.getName(), String.valueOf(user.getPassword()),user.getEmail());

        resp.sendRedirect("/index");

    }
}