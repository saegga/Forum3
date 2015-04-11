package mypackage;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/**
 * Created by sergei on 16.03.2015.
 */
public class ConnectJDBC {

    final String CHECK = "SELECT* FROM users";


    Connection connection = null;


    public ConnectJDBC() {
        try {

            PropertiesMy propertiesMy = new PropertiesMy();
            Properties properties = propertiesMy.getProp();
            String propFileName = "resource//config.properties";

            InputStream inputStream = getClass().getResourceAsStream(propFileName);
            properties.load(inputStream);

            String name = properties.getProperty("db.login");
            String password = properties.getProperty("db.password");
            String host = properties.getProperty("db.host");
            String f = properties.getProperty("forname");
            Class.forName(f);

            connection = DriverManager.getConnection(host,name,password);
            inputStream.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;

    }

    public boolean checkRegistration(Connection connection, HttpServletRequest req) {
        boolean find = false;
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(CHECK);
            while (resultSet.next()) {
                if (resultSet.getString("email").equals(req.getParameter("mail"))) {
                    find = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return find;
    }



}


