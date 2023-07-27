package interfaceadapters.LoginStudentInterfaceAdapters;

/**
 * Exception raised when there is an error in logging in a student.
 */
public class LoginUserFailed extends RuntimeException {

    public LoginUserFailed(String error) {
        super(error);
    }
}
