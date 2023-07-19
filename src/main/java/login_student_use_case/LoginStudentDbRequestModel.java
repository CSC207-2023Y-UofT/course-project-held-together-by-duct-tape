package login_student_use_case;

public class LoginStudentDbRequestModel {
    private String username;

    public LoginStudentDbRequestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
