package frameworksdrivers;

public interface Driver {
    public StudentDbGateway getStudentDbGateway();
    public SessionDbGateway getSessionDbGateway();
    public CourseDbGateway getCourseDbGateway();
}
