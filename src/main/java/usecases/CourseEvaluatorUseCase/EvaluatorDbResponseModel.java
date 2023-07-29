package usecases.CourseEvaluatorUseCase;

import java.util.List;

public class EvaluatorDbResponseModel {
    private final String courseId;
    private List<String> questions;
    private List<String> answers;
    private List<Integer> points;

    public EvaluatorDbResponseModel(String courseId) {
        this.courseId = courseId;
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

    public List<Integer> getPoints() {
        return points;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }
}
