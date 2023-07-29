package frameworksdrivers;

import frameworksdrivers.Gateways.CourseDbGateway;
import frameworksdrivers.Gateways.SessionDbGateway;
import frameworksdrivers.Gateways.StudentDbGateway;

/**
 * Driver that connects to the databases and creates the gateways. Each gateway has a reference to the connection so
 * that they are all able to communicate with the database.
 */
public interface Driver {
    StudentDbGateway getStudentDbGateway();
    SessionDbGateway getSessionDbGateway();
    CourseDbGateway getCourseDbGateway();
}
