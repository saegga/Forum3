package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by sergei on 20.03.2015.
 */

@WebServlet("/tst")
public class DBServletPost extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Main main = new Main();
        if (req.getRequestURI().equals("/posts") || req.getRequestURI().equals("/tst") ) {
            try {
                req.setAttribute("subj_id",req.getParameter("id"));
                int id;
                if(req.getParameter("id")!= null){
                     id = Integer.parseInt(req.getParameter("id"));
                }else{
                    id = Integer.parseInt((req.getAttribute("id")).toString());
                }
                HttpSession session =req.getSession(true) ;
                session.setAttribute("theme",id);

                req.setAttribute("post", main.getPosts(id));
                req.setAttribute("user", main.getUser(id));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/posts.jsp");
                dispatcher.forward(req, resp);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Main main = new Main();
        req.setCharacterEncoding("utf-8");
        try {
         int subjId = (Integer.parseInt(req.getSession().getAttribute("theme").toString()));
            main.addPosts(subjId ,req);
            req.setAttribute("id",req.getSession().getAttribute("theme"));
            doGet(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
