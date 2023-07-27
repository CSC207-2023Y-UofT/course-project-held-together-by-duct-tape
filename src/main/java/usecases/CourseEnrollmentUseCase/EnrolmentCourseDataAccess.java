package usecases.CourseEnrollmentUseCase;

public interface EnrolmentCourseDataAccess {
    public boolean existsByCourseId(String courseId);
    public void retrieveCourse(EnrolmentDbRequestModel requestModel);
}
