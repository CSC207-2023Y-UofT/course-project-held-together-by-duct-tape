package usecases.LoginStudentUseCase;

import interfaceadapters.LoginStudentInterfaceAdapters.LoginUserFailed;

/**
 * Interface that the loginPresenter must implement so the interactor can interact with the
 * presenter.
 */
public interface LoginStudentOutputBoundary {
    /**
     * Presenter must prepare a success view since the use case has run successfully.
     * Interacts with the responseModel to prepare the response model that will be used
     * by the view model.
     *
     * @param responseModel data structure with the username of the attempting login student.
     * @return response model with the username of the logged in student.
     */
    LoginStudentResponseModel prepareSuccessView(LoginStudentResponseModel responseModel);

    /**
     * Presenter must prepare a fail view since the use case has thrown an error.
     * The interactor will pass an error message, which the Presenter will throw.
     *
     * @param error message that will be thrown.
     * @throws LoginUserFailed exception.
     */
    LoginStudentResponseModel prepareFailView(String error) throws LoginUserFailed;
}
