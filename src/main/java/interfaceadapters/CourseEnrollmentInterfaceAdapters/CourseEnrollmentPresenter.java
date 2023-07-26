package interfaceadapters.CourseEnrollmentInterfaceAdapters;

import frameworksdrivers.CourseDbGateway;

import java.util.List;

public class CourseEnrollmentPresenter {
    private final CourseDbGateway courseDbGateway;
    public CourseEnrollmentPresenter(CourseDbGateway courseDbGateway) {
        this.courseDbGateway = courseDbGateway;
    }

    public List<String> getCourseIDs() {
        return courseDbGateway.getCourseIDs();
    }
}
