package interfaceadapters.LoginStudent;

import usecases.LoginStudentUseCase.LoginStudentOutputBoundary;
import usecases.LoginStudentUseCase.LoginStudentResponseModel;

public class LoginStudentPresenter implements LoginStudentOutputBoundary {
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
     * @return
     */
    public LoginStudentResponseModel prepareFailView(String error) {
        throw new RuntimeException(error);
    }
}
