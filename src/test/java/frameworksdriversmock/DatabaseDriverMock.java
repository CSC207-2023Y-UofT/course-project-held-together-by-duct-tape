package frameworksdriversmock;

import frameworksdrivers.Driver;

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
    public frameworksdrivers.StudentDbGateway getStudentDbGateway() {
        return null;
    }

    @Override
    public frameworksdrivers.SessionDbGateway getSessionDbGateway() {
        return null;
    }

    @Override
    public frameworksdrivers.CourseDbGateway getCourseDbGateway() {
        return null;
    }
}
