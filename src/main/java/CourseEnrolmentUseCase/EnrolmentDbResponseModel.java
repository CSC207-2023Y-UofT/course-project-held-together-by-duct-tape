package UseCases;

import entities.Course;

public class EnrolmentDbResponseModel {
    private Course course;
    public EnrolmentDbResponseModel(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
