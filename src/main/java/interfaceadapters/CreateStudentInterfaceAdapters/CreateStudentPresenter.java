package interfaceadapters.CreateStudentInterfaceAdapters;

import frameworksdrivers.Driver;
import usecases.CreateStudentUsecase.CreateStudentInputBoundary;
import usecases.CreateStudentUsecase.CreateStudentInteractor;
import usecases.CreateStudentUsecase.CreateStudentOutputBoundary;
import usecases.CreateStudentUsecase.CreateStudentResponseModel;

/**This class implements the CreateStudent output boundary and formats the success and fail messages
 * the different components required for the Create student usecase to run are also initialized
 * here so all that is necessary to render the screen is here*/
public class CreateStudentPresenter implements CreateStudentOutputBoundary {
    private final CreateStudentController createStudentController;
    private static Driver databaseDriver;
    public CreateStudentPresenter( Driver databaseDriver) {
        databaseDriver = databaseDriver;
        CreateStudentInputBoundary createStudentInteractor = new CreateStudentInteractor(
                databaseDriver.getStudentDbGateway(), this, databaseDriver.getCourseDbGateway());
        createStudentController = new CreateStudentController(createStudentInteractor);
    }
    /**This method retrieves the controller
     * @return CreateStudentController the controller of the program */
    public CreateStudentController getCreateStudentController() {
        return createStudentController;
    }

    /**This method formats and returns a success message based on the response model passed
     * @param responseModel is a response model that contains what is needed to format the success message */
    @Override
    public String getSuccessMessage(CreateStudentResponseModel responseModel) {
        return "You have successfully created a New student! Welcome" + " " + responseModel.getUsername();
    }

    /**This method formats and returns the message that is shown upon failure of creating a new student user*/
    @Override
    public String getFailMessage() {
        return "Sorry it appears that either the Username already exists, or your passwords don't match!";
    }
}
