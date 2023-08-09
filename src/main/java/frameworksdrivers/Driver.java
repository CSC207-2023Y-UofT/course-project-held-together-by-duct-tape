package frameworksdrivers;

import frameworksdrivers.gateways.CourseGateway;
import frameworksdrivers.gateways.SessionGateway;
import frameworksdrivers.gateways.StudentGateway;

/**
 * Driver that connects to the databases and creates the gateways. Each gateway has a reference to the connection so
 * that they are all able to communicate with the database.
 */
public interface Driver {
    StudentGateway getStudentDbGateway();
    SessionGateway getSessionDbGateway();
    CourseGateway getCourseDbGateway();
}
