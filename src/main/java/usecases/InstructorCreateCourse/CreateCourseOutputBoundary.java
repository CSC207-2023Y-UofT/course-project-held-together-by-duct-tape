package usecases.InstructorCreateCourse;
import entities.*;

public interface CreateCourseOutputBoundary {
    void courseCreated(CreateCourseResponseModel response);
    void showError(String errorMessage);
}

