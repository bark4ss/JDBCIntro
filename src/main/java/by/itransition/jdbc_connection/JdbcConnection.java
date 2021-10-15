package by.itransition.jdbc_connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

    private Connection connection;

    public Connection getConnection () {
        Properties properties = new Properties();

        Connection conn = null;
        try(InputStream in = JdbcConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(in);
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
