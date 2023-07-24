package courseEvaluator.UseCases;

import entities.Question;

import java.util.List;

public class EvaluatorDbResponseModel {
    private String courseId;
    private List<Question> questions;



    public void EnrolmentDbResponseModel(String courseId, List<Question> questions) {
        this.courseId = courseId;
        this.questions = questions;

    }

    public String getCourseId() {
        return courseId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
