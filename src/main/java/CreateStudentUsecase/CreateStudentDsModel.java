package CreateStudentUsecase;

public class CreateStudentDsModel {
    private String Student;

    public CreateStudentDsModel(String username){
        this.Student = username;
    }
    public String getUsername(){ return Student;}
}
