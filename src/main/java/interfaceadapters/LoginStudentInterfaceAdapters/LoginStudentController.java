package interfaceadapters.LoginStudentInterfaceAdapters;

import usecases.LoginStudentUseCase.LoginStudentInteractor;
import usecases.LoginStudentUseCase.LoginStudentRequestModel;
import usecases.LoginStudentUseCase.LoginStudentResponseModel;

public class LoginStudentController {

    private final LoginStudentInteractor interactor;

    public LoginStudentController(LoginStudentInteractor interactor) {
        this.interactor = interactor;
    }

    public LoginStudentResponseModel login(String username, String repeatUsername) {
        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username, repeatUsername);
        return interactor.login(requestModel);
    }
}
