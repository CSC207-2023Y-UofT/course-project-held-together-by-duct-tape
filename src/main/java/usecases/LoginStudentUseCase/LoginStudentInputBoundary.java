package usecases.LoginStudentUseCase;

/**
 * Interface that the interactor must implement.
 */
public interface LoginStudentInputBoundary {
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
    LoginStudentResponseModel login(LoginStudentRequestModel requestModel);
}
