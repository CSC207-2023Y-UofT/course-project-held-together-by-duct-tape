package useCases.createStudentUsecase;

/**
 * This class packages the user input required for creating a student.
 */
public class CreateStudentRequestModel {
    private final String username;
    private final String repeat;
    private final String password;

    /**
     * This constructs a request model that packages user input.
     *
     * @param username this is the username inputted by the user.
     * @param repeat this is the repeated password of the user.
     * @param password this is the password of the user.
     */
    public CreateStudentRequestModel(String username, String password, String repeat){
        this.username = username;
        this.password = password;
        this.repeat = repeat;
    }

    public String getUsername() {
        return username;
    }

    public  String getPassword(){
        return password;
    }

    public String getRepeat() {
        return repeat;
    }
}
