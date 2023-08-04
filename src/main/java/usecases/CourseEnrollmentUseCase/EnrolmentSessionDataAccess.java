package usecases.CourseEnrollmentUseCase;

public interface EnrolmentSessionDataAccess {
    boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel);
    void saveCourse(EnrolmentDbRequestModel requestModel);
    void deleteCourseSession();
    void deleteStudentSession();
}
