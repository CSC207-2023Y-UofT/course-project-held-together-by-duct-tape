package login_student_use_case;

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
