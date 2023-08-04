package usecases.CourseEvaluator;


import java.util.List;

public class EvaluatorDbResponseModel {
    private String courseId;
    private List<String> questions;
    private List<String> answers;

    private List<Integer> points;


    public void EnrolmentDbResponseModel(String courseId, List<String> questions, List<String> answers,
                                         List<Integer> points) {
        this.courseId = courseId;
        this.questions = questions;
        this.answers = answers;
        this.points = points;


    }
    public String getCourseId() {
        return courseId;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public List<Integer> getPoints(){return points;}

}
