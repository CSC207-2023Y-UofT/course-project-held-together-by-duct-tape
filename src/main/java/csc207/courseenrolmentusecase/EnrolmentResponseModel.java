package csc207.courseenrolmentusecase;

import csc207.entities.Question;

import java.util.List;
/**
 * Data structure which packages the course ID and the questions to be displayed on the screen.
 */
public class EnrolmentResponseModel {
    private String courseId;
    private List<Question> questions;

    public EnrolmentResponseModel(String courseId, List<Question> questions) {
        this.courseId = courseId;
        this.questions =  questions;
    }

    public String getCourseId() {
        return courseId;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
