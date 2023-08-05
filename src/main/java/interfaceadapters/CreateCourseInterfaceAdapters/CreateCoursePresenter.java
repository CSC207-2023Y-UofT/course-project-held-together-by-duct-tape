package interfaceadapters.CreateCourseInterfaceAdapters;

import entities.CourseBuilder.CourseFullBuilder;
import entities.CourseFactory;
import frameworksdrivers.DatabaseDriver;
import usecases.InstructorCreateCourseUseCase.CreateCourseInteractor;
import usecases.InstructorCreateCourseUseCase.CreateCourseOutputBoundary;
import usecases.InstructorCreateCourseUseCase.CreateCourseResponseModel;

public class CreateCoursePresenter implements CreateCourseOutputBoundary {
    private final CreateCourseController controller;

    public CreateCoursePresenter(DatabaseDriver driver){

        CreateCourseInteractor interactor = new CreateCourseInteractor(driver.getCourseDbGateway(), this);
        controller = new CreateCourseController(interactor);

    }
    public CreateCourseController getCreateCourseController() { return controller;}

    @Override
    public void courseCreated(CreateCourseResponseModel response) {
        throw new SuccessCreate("You created the course " + response.getCourseId());
    }

    /** Implements how the presenter handles the error message.
     // @throws FailedtoCreate indicating that the course wasn't created*/

    @Override
    public void showError(String errorMessage) {
        throw new FailedtoCreate(errorMessage);
    }
}
