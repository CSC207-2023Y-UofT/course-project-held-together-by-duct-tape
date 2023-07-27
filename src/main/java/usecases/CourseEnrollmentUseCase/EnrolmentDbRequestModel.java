package usecases.CourseEnrollmentUseCase;

import entities.Prerequisite;
import entities.Question;

import java.util.List;

public class EnrolmentDbRequestModel {
    private final String courseId;
    private List<Question> questions;
    private Prerequisite prerequisite;

    public EnrolmentDbRequestModel(String courseId) {
        this.courseId = courseId;
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

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setPrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
    }
}
