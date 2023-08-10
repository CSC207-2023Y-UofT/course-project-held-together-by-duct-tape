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
    void saveUser(LoginStudentDbRequestModel requestModel);

    /**
     * Delete the current user on the session database. This method is called after a user logs out of the program.
     * This method is also called during initialization of the databases: when the program shuts down or is exited
     * incorrectly, there may be data in the session database at the start of the program which would need
     * to be deleted.
     */
    void deleteStudentSession();
}
