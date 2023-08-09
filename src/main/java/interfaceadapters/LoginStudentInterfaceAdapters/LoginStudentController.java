package interfaceadapters.LoginStudentInterfaceAdapters;

import usecases.LoginStudentUseCase.LoginStudentInputBoundary;
import usecases.LoginStudentUseCase.LoginStudentRequestModel;
import usecases.LoginStudentUseCase.LoginStudentResponseModel;

/**
 * Controller for the login use case. The controller calls the interactor to run the use case after preparing
 * a request model with the necessary information.
 */
public class LoginStudentController {

    private final LoginStudentInputBoundary interactor;

    public LoginStudentController(LoginStudentInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Builds the request model by inputting the username and repeatUsername into a data structure. It
     * calls the interactor to run the login use case with the request model.
     *
     * @param username inputted by the user.
     * @param password inputted by the user.
     * @return ResponseModel with the username.
     */
    public LoginStudentResponseModel login(String username, String password) {
        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username, password);
        return interactor.login(requestModel);
    }
}
