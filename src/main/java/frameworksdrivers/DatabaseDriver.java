package frameworksdrivers;

import frameworksdrivers.Gateways.*;

/**
 * Driver that connects to the databases and creates the gateways. Each gateway has a reference to the connection so
 * that they are all able to communicate with the database.
 */
public class DatabaseDriver implements Driver {
    private static final DbConnection dbConnection = new DbConnection();
    private final StudentGateway studentDbGateway;
    private final SessionGateway sessionDbGateway;
    private final CourseGateway courseDbGateway;

    /**
     * Creates a new DbConnection (Database Connection) and creates the various gateways needed.
     */
    public DatabaseDriver() {
        studentDbGateway = new StudentDbGateway(dbConnection);
        sessionDbGateway = new SessionDbGateway(dbConnection);
        courseDbGateway = new CourseDbGateway(dbConnection);

        // Deletes previous sessions that might've not deleted if exited the program wrong.
        sessionDbGateway.deleteStudentSession();
        sessionDbGateway.deleteCourseSession();
    }

    public StudentGateway getStudentDbGateway() {
        return studentDbGateway;
    }

    public SessionGateway getSessionDbGateway() {
        return sessionDbGateway;
    }

    public CourseGateway getCourseDbGateway() {
        return courseDbGateway;
    }
}
