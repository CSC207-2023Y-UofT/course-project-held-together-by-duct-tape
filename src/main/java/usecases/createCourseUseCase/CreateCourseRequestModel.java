package usecases.createCourseUseCase;
import java.util.List;


/**
 * Represents a request model for creating a new course.
 */
public class CreateCourseRequestModel {
    private final String courseId;
    private final String prerequisite;

    private final Float prerequisite_grade;
    private final List<String> questions;
    private final List<String> answers;
    private final List<Integer> points;

    /**
     * Constructs a new CreateCourseRequestModel with the provided data.
     *
     * @param courseId           The ID of the new course.
     * @param prerequisite       The prerequisite for the course.
     * @param grade The grade required for the prerequisite.
     * @param questions          The list of questions for the course.
     * @param answers            The corresponding list of answers for the questions.
     * @param points             The list of points associated with each question.
     */
    public CreateCourseRequestModel(String courseId, String prerequisite, Float grade, List<String> questions, List<String> answers, List<Integer> points) {
        this.courseId = courseId;
        this.prerequisite = prerequisite;
        this.prerequisite_grade = grade;
        this.questions = questions;
        this.answers = answers;
        this.points = points;
    }

    /**
     * Returns the ID of the course.
     *
     * @return The course ID.
     */
    public String getCourseId() {
        return courseId;
    }


    /**
     * Returns the prerequisite for the course.
     *
     * @return The prerequisite.
     */
    public String getPrerequisite() {
        return prerequisite;
    }


    /**
     * Returns the grade required for the prerequisite.
     *
     * @return The prerequisite grade.
     */
    public Float getPrerequisite_grade(){return prerequisite_grade;}


    /**
     * Returns the list of questions for the course.
     *
     * @return The list of questions.
     */
    public List<String> getQuestions() {
        return questions;
    }


    /**
     * Returns the list of answers corresponding to the questions.
     *
     * @return The list of answers.
     */
    public List<String> getAnswers() {
        return answers;
    }


    /**
     * Returns the list of points associated with each question.
     *
     * @return The list of points.
     */
    public List<Integer> getPoints() {
        return points;
    }
}
