package login_student_use_case;

/**
 * Use Case Interactor, this is the object that runs the use case for attempting to log
 * in a student. Has references to the student gateway, session gateway, as well as the
 * presenter for the login screen.
 */
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

    /**
     * Use case for attempting to log in a student. The requestModel contains the
     * necessary information like the username and repeatUsername. If the username
     * does not exist, an error is thrown. If the username and repeatUsername don't
     * match, an error is thrown. If both conditions are satisfied, the username of
     * the student is saved to the Session database through the sessionDbGateway.
     * Then the presenter prepares success/fail views depending on each case.
     *
     * @param requestModel data structure packaging the usernames.
     * @return response model with the username of the logged in student.
     */
    @Override
    public LoginStudentResponseModel login(LoginStudentRequestModel requestModel) {
        if (!studentDbGateway.usernameExists(requestModel.getUsername())) {
            return loginPresenter.prepareFailView("Username does not exist.");
        } else if (!requestModel.getUsername().equals(requestModel.getRepeatUsername())) {
            return loginPresenter.prepareFailView("Usernames don't match.");
        }

        LoginStudentDbRequestModel dbRequestModel = new LoginStudentDbRequestModel(requestModel.getUsername());
        sessionDbGateway.save(dbRequestModel);

        LoginStudentResponseModel responseModel = new LoginStudentResponseModel(requestModel.getUsername());
        return loginPresenter.prepareSuccessView(responseModel);
    }
}
