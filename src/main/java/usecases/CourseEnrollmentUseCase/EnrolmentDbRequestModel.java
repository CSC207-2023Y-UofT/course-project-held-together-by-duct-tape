package usecases.CourseEnrollmentUseCase;

import java.util.List;

public class EnrolmentDbRequestModel {
    private final String courseID;
    private String prerequisiteID;
    private float prerequisiteGrade;
    private List<String> questions;
    private List<Integer> points;

    public EnrolmentDbRequestModel(String courseId) {
        this.courseID = courseId;
    }

    public String getCourseID() {
        return courseID;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public String getPrerequisiteID() {
        return prerequisiteID;
    }

    public float getPrerequisiteGrade() {
        return prerequisiteGrade;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public void setPrerequisiteID(String prerequisiteID) {
        this.prerequisiteID = prerequisiteID;
    }

    public void setPrerequisiteGrade(float prerequisiteGrade) {
        this.prerequisiteGrade = prerequisiteGrade;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }
}
