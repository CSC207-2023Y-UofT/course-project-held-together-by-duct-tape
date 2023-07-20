package usecases.LoginStudentUseCase;

/**
 * Interface that the sessionDbGateway must implement for the LoginInteractor to
 * ensure clean architecture and call on its methods.
 */
public interface LoginSessionDataAccess {
    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    void save(LoginStudentDbRequestModel requestModel);
}
