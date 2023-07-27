package usecases.CreateStudentUsecase;

import entities.Student;

import java.util.Map;

/**This class is a model that stores what is required to save for the database it may appear small, but it
 * allows for flexibility depending on if we want to expand and create a password functionality*/
public class CreateStudentDsModel {
    private final Student student;
    private final String password;
    public CreateStudentDsModel(Student student, String password){
       this.student = student;
       this.password = password;
    }
    public String getUsername(){ return student.getStudentId();}

    public Map<String, Integer> getCourseList(){return student.getCourses();}
    public String getPassword(){return password;}
}


