package login_student_use_case;

/**
 * Data structure that packages the output from the interactor to the output boundary
 * or presenter. The presenter only requires the username to display to the user that
 * a student with that username has been logged in.
 */
public class LoginStudentResponseModel {
    private String username;

    public LoginStudentResponseModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
