package usecases.loginStudentUseCase;

/**
 * Data structure that packages the input to the interactor such that the interactor does
 * not interact with raw data. The username and repeatUsername are the two things that
 * the student requires to log in.
 */
public class LoginStudentRequestModel {
    private String username;
    private String password;

    public LoginStudentRequestModel(String username, String repeatUsername) {
        this.username = username;
        this.password = repeatUsername;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String repeatUsername) {
        this.password = repeatUsername;
    }
}
