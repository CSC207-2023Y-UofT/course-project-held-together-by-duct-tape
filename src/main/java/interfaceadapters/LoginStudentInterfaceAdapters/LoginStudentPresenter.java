package interfaceadapters.LoginStudentInterfaceAdapters;

import frameworksdrivers.Driver;
import usecases.LoginStudentUseCase.LoginStudentInteractor;
import usecases.LoginStudentUseCase.LoginStudentOutputBoundary;
import usecases.LoginStudentUseCase.LoginStudentResponseModel;

/**
 * Presenter for the login use case. This class prepares a success view by preparing the response model.
 * In the fail view, it throws exceptions that must be handled.
 */
public class LoginStudentPresenter implements LoginStudentOutputBoundary {
    private final LoginStudentController loginController;

    public LoginStudentPresenter(Driver databaseDriver) {
        LoginStudentInteractor loginInteractor = new LoginStudentInteractor(databaseDriver.getStudentDbGateway(), databaseDriver.getSessionDbGateway(), this);
        this.loginController = new LoginStudentController(loginInteractor);
    }

    public LoginStudentController getLoginController() {
        return loginController;
    }

    /**
     * Presenter must prepare a success view since the use case has run successfully.
     * Interacts with the responseModel to prepare the response model that will be used
     * by the view model.
     *
     * @param responseModel data structure with the username of the attempting login student.
     * @return response model with the username of the logged in student.
     */
    public LoginStudentResponseModel prepareSuccessView(LoginStudentResponseModel responseModel) {
        return responseModel;
    }

    /**
     * Presenter must prepare a fail view since the use case has thrown an error.
     * The interactor will pass an error message, which the Presenter will throw.
     *
     * @param error message that will be thrown.
     */
    public LoginStudentResponseModel prepareFailView(String error) {
        throw new LoginUserFailed(error);
    }
}
