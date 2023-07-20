package usecases.LoginStudentUseCase;

/**
 * Data structure that packages the input to the interactor such that the interactor does
 * not interact with raw data. The username and repeatUsername are the two things that
 * the student requires to log in.
 */
public class LoginStudentRequestModel {
    private String username;
    private String repeatUsername;

    public LoginStudentRequestModel(String username, String repeatUsername) {
        this.username = username;
        this.repeatUsername = repeatUsername;
    }

    public String getUsername() {
        return this.username;
    }

    public String getRepeatUsername() {
        return this.repeatUsername;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRepeatUsername(String repeatUsername) {
        this.repeatUsername = repeatUsername;
    }
}
