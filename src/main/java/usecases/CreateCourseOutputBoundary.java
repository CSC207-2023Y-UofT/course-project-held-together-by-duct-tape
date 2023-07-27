package usecases.InstructorCreateCoursesUseCase;
import entities.*;

public interface CreateCourseOutputBoundary {
    void courseCreated(CreateCourseResponseModel response);
    void showError(String errorMessage);
}

