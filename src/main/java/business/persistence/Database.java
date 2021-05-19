package business.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Creates the database connection
 */
public class Database {
    private Connection connection;
    private final String USER;
    private final String PASSWORD;
    private final String URL;

    /**
     * @param user     TDB
     * @param password Password for the database connection
     * @param url      Url for the database connection
     * @throws ClassNotFoundException TDB - Problem occoured when loading the class
     */
    public Database(String user, String password, String url) throws ClassNotFoundException {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null) {
            // Prod: Get variables (if any) in setenv.sh in Tomcats bin folder
            USER = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
            URL = System.getenv("JDBC_CONNECTION_STRING");
        } else {
            USER = user;
            PASSWORD = password;
            URL = url;
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public Connection connect() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
}
