package interfaceadapters.createCourseInterfaceAdapters;

import frameworksdrivers.Driver;
import usecases.createCourseUseCase.CreateCourseInteractor;
import usecases.createCourseUseCase.CreateCourseOutputBoundary;
import usecases.createCourseUseCase.CreateCourseResponseModel;

/**
 * Presenter for the Create Course use case. This class prepares the view by handling the response
 * and error scenarios of the Create Course operation. It interacts with the response model to prepare
 * the data that will be presented to the view.
 */
public class CreateCoursePresenter implements CreateCourseOutputBoundary {
    private final CreateCourseController controller;

    /**
     * Constructor for the CreateCoursePresenter class. Initializes the presenter by creating an interactor,
     * setting up a controller, and associating them for handling the Create Course use case.
     *
     * @param driver DatabaseDriver object providing access to required gateways.
     */
    public CreateCoursePresenter(Driver driver){
        CreateCourseInteractor interactor = new CreateCourseInteractor(driver.getCourseDbGateway(), this);
        controller = new CreateCourseController(interactor);
    }

    /**
     * Retrieves the associated CreateCourseController instance.
     *
     * @return CreateCourseController instance associated with this presenter.
     */
    public CreateCourseController getCreateCourseController() { return controller;}

    /**
     * Handles the successful scenario of the Create Course operation. Prepares the response view
     * by throwing a SuccessCreate exception containing the success message.
     *
     * @param response CreateCourseResponseModel containing the created course's information.
     * @throws SuccessCreate Exception indicating successful course creation.
     */
    @Override
    public String courseCreated(CreateCourseResponseModel response) {
        return "You created the course " + response.getCourseId();
    }

    /**
     * Handles the error scenario of the Create Course operation. Prepares the error view by
     * throwing a FailedtoCreate exception with the provided error message.
     *
     * @param errorMessage Error message indicating the cause of course creation failure.
     * @throws FailedtoCreate Exception indicating failed course creation.
     */
    @Override
    public void showError(String errorMessage) {
        throw new FailedtoCreate(errorMessage);
    }
}
