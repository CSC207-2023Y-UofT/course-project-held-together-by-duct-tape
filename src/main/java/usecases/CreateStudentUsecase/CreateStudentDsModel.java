package usecases.CreateStudentUsecase;
/**This class is a model that stores what is required to save for the database it may appear small, but it
 * allows for flexibility depending on if we want to expand and create a password functionality*/
public class CreateStudentDsModel {
    private String Student;
    public CreateStudentDsModel(String username){
        this.Student = username;
    }
    public String getUsername(){ return Student;}
}
