package useCases.createStudentUsecase;

/**
 * Packages what is necessary to present the success message which in this case is the username chosen.
 */
public class CreateStudentResponseModel {
   private final String username;

    public CreateStudentResponseModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
