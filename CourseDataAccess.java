package usecases.InstructorCreateCoursesUseCase;
import entities.*;


public interface CourseDataAccess {
    boolean courseExists(String courseId);
    void saveCourse(Course course);
}
