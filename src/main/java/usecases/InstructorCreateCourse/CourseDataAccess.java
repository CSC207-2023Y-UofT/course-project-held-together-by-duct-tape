package usecases.InstructorCreateCourse;
import entities.*;


public interface CourseDataAccess {
    boolean courseExists(String courseId);
    void saveCourse(Course course);
}
