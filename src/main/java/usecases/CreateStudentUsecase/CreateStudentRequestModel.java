package usecases.CreateStudentUsecase;
/**This class packages the user input required for creating a student */
public class CreateStudentRequestModel {
    private String username;
    private String repeat;
    /**This constructs a request model that packages user input
     * @param repeat this is the repeated input of the username
     * @param username this is the username inputed by the user*/
    public CreateStudentRequestModel(String username, String repeat){
        this.repeat = repeat;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getRepeat() {
        return repeat;
    }
}
