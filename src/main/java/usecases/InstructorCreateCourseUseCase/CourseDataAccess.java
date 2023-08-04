package usecases.InstructorCreateCourseUseCase;


public interface CourseDataAccess {
    boolean existsByCourseId(String courseId);
    void saveCourse(CourseDbRequestModel course);
}
