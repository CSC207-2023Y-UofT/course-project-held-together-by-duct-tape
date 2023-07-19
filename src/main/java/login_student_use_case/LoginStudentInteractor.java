package login_student_use_case;

public class LoginStudentInteractor implements LoginStudentInputBoundary {
    private final LoginStudentDataAccess studentDbGateway;
    private final LoginSessionDataAccess sessionDbGateway;
    private final LoginStudentOutputBoundary loginPresenter;

    public LoginStudentInteractor(LoginStudentDataAccess studentDbGateway, LoginSessionDataAccess sessionDbGateway,
                                  LoginStudentOutputBoundary loginPresenter) {
        this.studentDbGateway = studentDbGateway;
        this.sessionDbGateway = sessionDbGateway;
        this.loginPresenter = loginPresenter;
    }

    @Override
    public LoginStudentResponseModel login(LoginStudentRequestModel requestModel) {
        if (!studentDbGateway.usernameExists(requestModel.getUsername())) {
            return loginPresenter.prepareFailView("Username does not exist.");
        }

        LoginStudentDbRequestModel dbRequestModel = new LoginStudentDbRequestModel(requestModel.getUsername());
        sessionDbGateway.save(dbRequestModel);

        LoginStudentResponseModel responseModel = new LoginStudentResponseModel(requestModel.getUsername());
        return loginPresenter.prepareSuccessView(responseModel);
    }
}
