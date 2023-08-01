package interfaceadapters.CreateCourseInterfaceAdapters;

import usecases.InstructorCreateCourseUseCase.CreateCourseOutputBoundary;
import usecases.InstructorCreateCourseUseCase.CreateCourseResponseModel;

public class CreateCoursePresenter implements CreateCourseOutputBoundary {
    @Override
    public void courseCreated(CreateCourseResponseModel response) {
        // Implement how the presenter handles the successful course creation response.
        // For example, you can display a success message or perform any necessary UI updates.
    }

    @Override
    public void showError(String errorMessage) {
        // Implement how the presenter handles the error message.
        // For example, you can display the error message on the UI or log the error.
    }
}
