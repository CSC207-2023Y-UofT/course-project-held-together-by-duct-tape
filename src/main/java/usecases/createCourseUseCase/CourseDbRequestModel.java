package usecases.createCourseUseCase;

import java.util.*;

/**
 * The CourseDbRequestModel class represents the data required to interact with the course database
 * when creating or updating a course.
 */
public class CourseDbRequestModel {
    // Define the data required to interact with the course database
    private final String courseId;// Unique identifier for the course
    private final String prereq;// Prerequisite course ID
    private final Float prereqGrade;// Minimum grade required in the prerequisite course
    private final List<String> questions;// List of questions for the course
    private final List<String> answers;// Corresponding answers to the questions
    private final List<Integer> points;// Points awarded for each question


    /**
     * Gets the unique identifier for the course.
     *
     * @return The course ID.
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Gets the prerequisite course ID.
     *
     * @return The prerequisite course ID.
     */
    public String getPrereq() {
        return prereq;
    }
    /**
     * Gets the minimum grade required in the prerequisite course.
     *
     * @return The minimum prerequisite grade.
     */
    public Float getPrereqGrade() {
        return prereqGrade;
    }

    /**
     * Gets the list of questions for the course.
     *
     * @return List of questions.
     */
    public List<String> getQuestions() {
        return questions;
    }

    /**
     * Gets the corresponding answers to the questions.
     *
     * @return List of answers.
     */
    public List<String> getAnswers() {
        return answers;
    }

    /**
     * Gets the points awarded for each question.
     *
     * @return List of points.
     */
    public List<Integer> getPoints() {
        return points;
    }

    /**
     * Constructs a new CourseDbRequestModel with the specified parameters.
     *
     * @param courseId     The unique identifier for the course.
     * @param prereq       The prerequisite course ID.
     * @param prereqGrade  The minimum grade required in the prerequisite course.
     * @param questions    List of questions for the course.
     * @param answers      Corresponding answers to the questions.
     * @param points       Points awarded for each question.
     */
    public CourseDbRequestModel(String courseId, String prereq, Float prereqGrade, List<String> questions,
                                List<String> answers, List<Integer> points ){
        this.points = points;
        this.prereq = prereq;
        this.questions = questions;
        this.answers = answers;
        this.prereqGrade = prereqGrade;
        this.courseId = courseId;


    }

}
