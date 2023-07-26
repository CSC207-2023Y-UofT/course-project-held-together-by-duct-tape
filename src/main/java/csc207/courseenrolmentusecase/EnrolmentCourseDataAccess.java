package csc207.courseenrolmentusecase;

public interface EnrolmentCourseDataAccess {
    public boolean existsByCourseId(String courseId);
    public EnrolmentDbResponseModel retrieveCourse(String courseId);
}
