package frameworksdrivers;

import java.sql.*;
import java.util.Properties;

public class DbConnection {

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/course_simulator";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "coursesimgroup";

    private Properties properties;
    protected Connection connection;

    public DbConnection() {
        this.properties = getProperties();
        this.connection = connect();
    }

    public Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    public Connection connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (SQLException e) {
                System.out.println("Cannot connect to database.");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
