package usecases.CreateStudentUsecase;
/**This class is a model that stores what is required to save for the database it may appear small, but it
 * allows for flexibility depending on if we want to expand and create a password functionality*/
public class CreateStudentDsModel {
    private String student;
    // private Student student;
    public CreateStudentDsModel(String username){ // parameter would be Student student instead
        this.student = username; // this.student = student.getStudentId()
    }
    public String getUsername(){ return student;}} // return student.getStudentId()

 // public Map<String, Integer> getCoursemap(){return student.getCourses;}}
