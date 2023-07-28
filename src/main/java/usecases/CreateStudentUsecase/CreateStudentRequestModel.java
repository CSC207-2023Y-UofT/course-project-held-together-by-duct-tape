package usecases.CreateStudentUsecase;
/**This class packages the user input required for creating a student */
public class CreateStudentRequestModel {
    private final String username;
    private final String repeat;
    private final String password;
    /**This constructs a request model that packages user input
     * @param repeat this is the repeated input of the username
     * @param username this is the username inputed by the user*/
    public CreateStudentRequestModel(String username, String repeat, String password){
        this.repeat = repeat;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getRepeat() {
        return repeat;
    }

    public  String getPassword(){return password;}
}
