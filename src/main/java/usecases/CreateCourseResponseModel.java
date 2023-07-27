package usecases.InstructorCreateCoursesUseCase;
import java.util.List;

public class CreateCourseResponseModel {
    private final String courseId;

    // Constructor
    public CreateCourseResponseModel(String courseId) {
        this.courseId = courseId;
    }

    // Getter
    public String getCourseId() {
        return courseId;
    }
}
