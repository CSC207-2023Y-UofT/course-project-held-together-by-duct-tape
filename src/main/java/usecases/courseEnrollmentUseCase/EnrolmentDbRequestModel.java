package usecases.courseEnrollmentUseCase;

import java.util.List;

/**
 * Data structure that packages the course id, the course's prerequisites, questions, and points.
 * The prerequisites will be used by the check prerequisites interactor in order to determine whether the student is
 * allowed to enroll in this course. The id, questions and points will be saved to the session database.
 */
public class EnrolmentDbRequestModel {
    private final String courseID;
    private String prerequisiteID;
    private float prerequisiteGrade;
    private List<String> questions;
    private List<Integer> points;

    /**
     * Initializes the request model.
     * @param courseId the course ID for the course in which the student enrolls.
     */
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
