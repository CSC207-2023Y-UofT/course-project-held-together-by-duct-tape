package frameworksDrivers;

import frameworksDrivers.gateways.CourseGateway;
import frameworksDrivers.gateways.SessionGateway;
import frameworksDrivers.gateways.StudentGateway;

/**
 * Driver that connects to the databases and creates the gateways. Each gateway has a reference to the connection so
 * that they are all able to communicate with the database.
 */
public interface Driver {
    StudentGateway getStudentDbGateway();
    SessionGateway getSessionDbGateway();
    CourseGateway getCourseDbGateway();
}
