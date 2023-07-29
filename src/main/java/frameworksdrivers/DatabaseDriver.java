package frameworksdrivers;

import frameworksdrivers.Gateways.CourseDbGateway;
import frameworksdrivers.Gateways.SessionDbGateway;
import frameworksdrivers.Gateways.StudentDbGateway;

public class DatabaseDriver implements Driver {
    private final StudentDbGateway studentDbGateway;
    private final SessionDbGateway sessionDbGateway;
    private final CourseDbGateway courseDbGateway;

    public DatabaseDriver() {
        DbConnection dbConnection = new DbConnection();
        studentDbGateway = new StudentDbGateway(dbConnection);
        sessionDbGateway = new SessionDbGateway(dbConnection);
        courseDbGateway = new CourseDbGateway(dbConnection);
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
