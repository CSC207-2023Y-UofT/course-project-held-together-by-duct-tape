package frameworksdrivers;

import frameworksdrivers.Gateways.CourseDbGateway;
import frameworksdrivers.Gateways.SessionDbGateway;
import frameworksdrivers.Gateways.StudentDbGateway;

/**
 * Driver that connects to the databases and creates the gateways. Each gateway has a reference to the connection so
 * that they are all able to communicate with the database.
 */
public class DatabaseDriver implements Driver {
    private final StudentDbGateway studentDbGateway;
    private final SessionDbGateway sessionDbGateway;
    private final CourseDbGateway courseDbGateway;

    /**
     * Creates a new DbConnection (Database Connection) and creates the various gateways needed.
     */
    public DatabaseDriver() {
        DbConnection dbConnection = new DbConnection();
        studentDbGateway = new StudentDbGateway(dbConnection);
        sessionDbGateway = new SessionDbGateway(dbConnection);
        courseDbGateway = new CourseDbGateway(dbConnection);

        // Deletes previous sessions that might've not deleted if exited the program wrong.
        sessionDbGateway.deleteStudentSession();
        sessionDbGateway.deleteCourseSession();
    }

    public StudentDbGateway getStudentDbGateway() {
        return studentDbGateway;
    }

    public SessionDbGateway getSessionDbGateway() {
        return sessionDbGateway;
    }

    public CourseDbGateway getCourseDbGateway() {
        return courseDbGateway;
    }
}
