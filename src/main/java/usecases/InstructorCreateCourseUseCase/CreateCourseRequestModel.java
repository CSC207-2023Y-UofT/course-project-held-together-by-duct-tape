package usecases.InstructorCreateCourseUseCase;
import java.util.List;

public class CreateCourseRequestModel {
    private final String courseId;
    private final String prerequisite;

    private final Float prerequisite_grade;
    private final List<String> questions;
    private final List<String> answers;
    private final List<Integer> points;

    // Constructor
    public CreateCourseRequestModel(String courseId, String prerequisite, Float prerequisite_grade, List<String> questions, List<String> answers, List<Integer> points) {
        this.courseId = courseId;
        this.prerequisite = prerequisite;
        prerequisite_grade = null;
        this.prerequisite_grade = prerequisite_grade;
        this.questions = questions;
        this.answers = answers;
        this.points = points;
    }

    // Getters
    public String getCourseId() {
        return courseId;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public Float getPrerequisite_grade(){return prerequisite_grade;}

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public List<Integer> getPoints() {
        return points;
    }
}
