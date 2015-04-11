package mypackage;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sergei on 10.03.2015.
 */
public class Main {
    static ResultSet resultSet;

    private static final String GET_ALL = "SELECT * FROM forums;";
    private static final String GET_SUBJECTS = "SELECT * FROM subjects,forums WHERE forums.id=subjects.forum_id";
    private static final String GET_POSTS = "SELECT * FROM posts,subjects WHERE posts.subject_id=subjects.id";
    private static final String GET_USER = "SELECT * FROM users,posts,subjects WHERE user_id=users.id and posts.subject_id=subjects.id";

    private static final String POSTING = "INSERT INTO posts(dt, user_id, txt, subject_id, reply_to) VALUE(?,?,?,?,?)";
    private static final String GET_ONE_USER = "SELECT * FROM users;";
    private static final String SQL = "SELECT name,password,id,email FROM users";

    public List<Forums> getForums() throws SQLException {

        ArrayList<Forums> forumsList = new ArrayList<Forums>();
        Statement statement = getStatement();
        ResultSet resultSet = statement.executeQuery(GET_ALL);
        while (resultSet.next()) {
            forumsList.add(new Forums(resultSet.getInt("id"),
                    resultSet.getString("name")));
        }
        statement.cancel();
        statement.close();
        if (!resultSet.isClosed()) {
            resultSet.close();
        }
        return forumsList;
    }

    public List<Subject> getSubjects(int id) throws SQLException {
        Statement statement = getStatement();
        resultSet = statement.executeQuery(GET_SUBJECTS);
        ArrayList<Subject> subjectList = new ArrayList<Subject>();
        while (resultSet.next()) {
            if (id == resultSet.getInt("forum_id"))
                subjectList.add(new Subject(resultSet.getInt("id"),
                        resultSet.getString("name")));
        }
        statement.cancel();
        statement.close();
        if (!resultSet.isClosed()) {
            resultSet.close();
        }
        return subjectList;

    }
    public List<Posts> getPosts(int id) throws SQLException, UnsupportedEncodingException {
        Statement statement = getStatement();
        resultSet = statement.executeQuery(GET_POSTS);
        ArrayList<Posts> postsList = new ArrayList<Posts>();
        while (resultSet.next()) {

            if (id == resultSet.getInt("subject_id")) {
                 resultSet.getString("txt");
                String s = new String(resultSet.getString("txt").getBytes("utf-8"));
                postsList.add(new Posts(s, resultSet.getInt("subject_id"),
                        resultSet.getDate("dt"), resultSet.getInt("user_id")));
            }
        }
        statement.cancel();
        statement.close();
        if (!resultSet.isClosed()) {
            resultSet.close();
        }
        return postsList;
    }

    public List<Users> getUser(int id) throws SQLException {
        Statement statement = getStatement();
        resultSet = statement.executeQuery(GET_USER);
        ArrayList<Users> userList = new ArrayList<Users>();
        while (resultSet.next()) {
            if (id == resultSet.getInt("subject_id")) {

                userList.add(new Users(resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getInt("password"), resultSet.getBoolean("isAdmin")));
            }
        }
        return userList;
    }

    public Statement getStatement() throws SQLException {

        ConnectJDBC currentConnect = new ConnectJDBC();
        Connection connection = currentConnect.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public void addPosts(int subjId, HttpServletRequest req) throws SQLException, UnsupportedEncodingException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.getConnection();
       // req.setCharacterEncoding("UTF-8");
        Date d = new Date();
        java.sql.Date date = new java.sql.Date(d.getTime());
        PreparedStatement statement = connection.prepareStatement(POSTING);
        try {
            String caption = new String(req.getParameter("post").getBytes("ISO-8859-1"), "windows-1252");
            String cp = req.getParameter("post");
            statement.setDate(1, date);
            statement.setInt(2, (Integer) req.getSession().getAttribute("currentId"));
            statement.setNString(3, req.getParameter("post"));
            statement.setInt(4, subjId);
            statement.setInt(5, 1);
            statement.execute();

        } catch (SQLException e) {
            Logger.getLogger(e.getSQLState());
        }
    }


    public void insertNewUser(Users user) {
        final String INSERT_NEW = "INSERT INTO users(name, email, password, isAdmin) VALUE(?,?,?,?)";
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3, String.valueOf(user.getPassword()));
            preparedStatement.setBoolean(4, true);
            preparedStatement.execute();
            preparedStatement.cancel();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Users getOneUser(int id) throws SQLException {//возвращает одного юзера
        Users user = new Users();
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection1 = connectJDBC.getConnection();
        Statement statement = connection1.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ONE_USER);
        while (resultSet.next()) {
            if (id == resultSet.getInt("id")) {
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setId(resultSet.getInt("id"));
            }
        }
        statement.cancel();
        statement.close();
        if (!resultSet.isClosed()) {
            resultSet.close();
        }

        return user;
    }

    public ResultSet getAllUsers() throws SQLException {
        ResultSet rs = null;
        ConnectJDBC connection = new ConnectJDBC();
        Connection currentConnection = connection.getConnection();
        Statement statement = currentConnection.createStatement();
        statement.executeQuery(SQL);
        rs = statement.getResultSet();
        return rs;
    }
    public int getIdSession() throws SQLException {
        ConnectJDBC connection = new ConnectJDBC();
        Connection currentConnection = connection.getConnection();
        Statement stat = currentConnection.createStatement();
        String ID = "SELECT id FROM users";
        ResultSet resultSet = stat.executeQuery(ID);
        resultSet.last();
        return resultSet.getInt("id");
    }
//    public void setSession(HttpServletRequest req){
//        HttpSession session = req.getSession(true);
//        session.setAttribute("flag", true);
//        session.setAttribute("email", rs.getString("email"));
//        session.setAttribute("currentId", rs.getInt("id"));
//    }
}




