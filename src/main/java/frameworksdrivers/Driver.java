package frameworksdrivers;

import frameworksdrivers.Gateways.CourseDbGateway;
import frameworksdrivers.Gateways.SessionDbGateway;
import frameworksdrivers.Gateways.StudentDbGateway;

public interface Driver {
    public StudentDbGateway getStudentDbGateway();
    public SessionDbGateway getSessionDbGateway();
    public CourseDbGateway getCourseDbGateway();
}
