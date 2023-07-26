package courseEvaluator.UseCases;

import entities.CourseFactory;
import entities.Question;

import java.util.List;

public class EvaluatorDbResponseModel {
    private String courseId;
    private List<Question> questions;
    private List<String> answers;







    public void EnrolmentDbResponseModel(String courseId, List<Question> questions, List<String> answers) {
        this.courseId = courseId;
        this.questions = questions;
        this.answers = answers;


    }
    public String getCourseId() {
        return courseId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<String> getAnswers(List<String> answers) {
        return answers;
    }
}
