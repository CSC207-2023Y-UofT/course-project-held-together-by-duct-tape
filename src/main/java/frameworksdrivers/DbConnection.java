package frameworksdrivers;

import java.sql.*;
import java.util.Properties;

/**
 * Sets up the Database connection with MySQL. Contains the necessary information to connect to the database. All
 * the gateways will get the connection from the connection instance attribute so that they all have the same
 * connection to the database.
 */
public class DbConnection {
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/course_simulator";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "coursesimgroup";

    private Properties properties;
    private Connection connection;

    public DbConnection() {
        this.properties = getProperties();
        this.connection = connect();
    }

    /**
     * Gets the necessary properties that will be used to connect to the database. In this case only the
     * username and password.
     *
     * @return Properties with the username and password of the database.
     */
    public Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    /**
     * Returns the connection to the database if successful. Uses the properties to attempt to connect to the
     * database.
     *
     * @return Connection to the database.
     */
    public Connection connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
                System.out.println("Database connection successful.");
            } catch (SQLException e) {
                System.out.println("Cannot connect to database.");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
