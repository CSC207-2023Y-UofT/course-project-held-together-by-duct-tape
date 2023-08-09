package frameworksdriversmock;

import frameworksdrivers.Driver;
import frameworksdrivers.gateways.CourseDbGateway;
import frameworksdrivers.gateways.SessionDbGateway;
import frameworksdrivers.gateways.StudentDbGateway;

/**
 * Mock driver created to ensure the tests run with mock methods and do not connect to the database.
 * The override methods are there so that DatabaseDriverMock can implement the Driver interface and thus
 * could be passed in to the various elements of the program. The overridden methods must not be called since
 * these return null values. Instead, to get the testing gateways, call the methods with Mock at the end.
 */
public class DatabaseDriverMock implements Driver {
    private final StudentDbGatewayMock studentDbGateway;
    private final SessionDbGatewayMock sessionDbGateway;
    private final CourseDbGatewayMock courseDbGateway;

    public DatabaseDriverMock() {
        studentDbGateway = new StudentDbGatewayMock();
        sessionDbGateway = new SessionDbGatewayMock();
        courseDbGateway = new CourseDbGatewayMock();
    }

    public StudentDbGatewayMock getStudentDbGatewayMock() {
        return studentDbGateway;
    }

    public SessionDbGatewayMock getSessionDbGatewayMock() {
        return sessionDbGateway;
    }

    public CourseDbGatewayMock getCourseDbGatewayMock() {
        return courseDbGateway;
    }

    @Override
    public StudentDbGateway getStudentDbGateway() {
        return null;
    }

    @Override
    public SessionDbGateway getSessionDbGateway() {
        return null;
    }

    @Override
    public CourseDbGateway getCourseDbGateway() {
        return null;
    }
}
