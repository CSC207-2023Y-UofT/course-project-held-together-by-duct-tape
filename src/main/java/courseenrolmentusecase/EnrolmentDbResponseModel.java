package courseenrolmentusecase;

import entities.Prerequisite;
import entities.Question;

import java.util.List;

public class EnrolmentDbResponseModel {
    private String courseId;
    private List<Question> questions;
    private Prerequisite prerequisite;
    public EnrolmentDbResponseModel(String courseId, List<Question> questions, Prerequisite prerequisite) {
        this.courseId = courseId;
        this.questions = questions;
        this.prerequisite = prerequisite;
    }

    public String getCourseId() {
        return courseId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Prerequisite getPrerequisite() {
        return prerequisite;
    }
}
