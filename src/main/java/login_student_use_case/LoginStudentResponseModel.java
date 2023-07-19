package login_student_use_case;

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
