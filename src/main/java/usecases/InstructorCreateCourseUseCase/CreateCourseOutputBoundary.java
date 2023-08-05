package usecases.InstructorCreateCourseUseCase;

/**
 * This interface is implemented by a presenter to separate concerns and adhere to clean architecture
 * for the output of the Create Course use case.
 */
public interface CreateCourseOutputBoundary {

    /**
     * Called when a new course has been successfully created.
     *
     * @param response The response model containing relevant information about the created course.
     */
    void courseCreated(CreateCourseResponseModel response);

    /**
     * Called to display an error message when course creation encounters an error.
     *
     * @param errorMessage The error message describing the issue with course creation.
     */
    void showError(String errorMessage);
}

