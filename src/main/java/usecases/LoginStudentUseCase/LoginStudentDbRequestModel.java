package usecases.LoginStudentUseCase;

import java.util.Map;

/**
 * Data structure that packages the necessary information from the interactor for the gateway
 * to do its job. The username is the only instance required as the Student gateway will check
 * if the username exists to be able to log in a student, and the Session gateway will save the
 * students username to the Session database to keep them logged in during the session.
 */
public class LoginStudentDbRequestModel {
    private String username;
    private Map<String, Float> courses;

    public LoginStudentDbRequestModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public Map<String, Float> getCourses() {
        return this.courses;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCourses(Map<String, Float> courses) {
        this.courses = courses;
    }
}
