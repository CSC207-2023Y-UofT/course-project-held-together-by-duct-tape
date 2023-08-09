package usecases.loginStudentUseCase;

/**
 * Interface that the studentDbGateway must implement for the LoginStudentInteractor to
 * ensure clean architecture and call on its methods.
 */
public interface LoginStudentDataAccess {
    /**
     * Method returns a boolean whether a username exists in the student database.
     *
     * @param username that will be checked.
     * @return boolean that indicates if the username exists.
     */
    boolean usernameExists(String username);

    /**
     * Method that adds the student courses to the request model.
     *
     * @param dbRequestModel request model that is updated with the students courses.
     */
    void getUser(LoginStudentDbRequestModel dbRequestModel);

    /**
     * Method that gives the database a request model with the username and password of the user trying to log in, and
     * returns a boolean whether this user has the matching password.
     *
     * @param requestModel with the username and password.
     * @return true if password matches, false otherwise.
     */
    boolean checkPassword(LoginStudentRequestModel requestModel);
}
