package usecases.InstructorCreateCourseUseCase;

public interface CreateCourseOutputBoundary {
    void courseCreated(CreateCourseResponseModel response);
    void showError(String errorMessage);
}

