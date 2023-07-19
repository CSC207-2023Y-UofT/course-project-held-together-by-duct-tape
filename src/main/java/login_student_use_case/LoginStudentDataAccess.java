package login_student_use_case;

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
}
