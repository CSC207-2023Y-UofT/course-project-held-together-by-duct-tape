package UseCases;

import entities.Question;

import java.util.List;

public class EnrolmentResponseModel {
    private EnrolmentDbResponseModel course;
    public EnrolmentResponseModel(EnrolmentDbResponseModel course) {
        this.course = course;
    }
    public List<Question> getQuestions() {
        return course.getCourse().getQuestions();
    }
    public String getCourseId() {
        return course.getCourse().getCourseId();
    }
}
