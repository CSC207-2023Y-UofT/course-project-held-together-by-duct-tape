package usecases.RunCourseUseCase;
import java.util.List;
import entities.Question;

public class RunCourseDbRequestModel {

    private String id;
    private List<Question> questions;
    private List<String> answers;
    private List<Integer> points;
    public RunCourseDbRequestModel(String id, List<Question> questions, List<String> answers, List<Integer> points){
        this.id = id;
        this.questions = questions;
        this.answers = answers;
        this.points = points;
    }
}
