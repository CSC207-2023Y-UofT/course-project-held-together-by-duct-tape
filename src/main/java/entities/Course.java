package entities;
import java.util.List;
import java.util.Iterator;

/**
 * A course with a unique course id and prerequisite. There are associated
 * questions and answers.
 */
public class Course implements Iterable<Question>{
    private final String courseId;
    private final Prerequisite prerequisite;
    private final List<Question> questions;

    /**
     * Construct a course with courseId, prerequisite and a list of questions.
     *
     * @param courseId the unique course Id.
     * @param prerequisite the prerequisite to take this course.
     * @param questions the list of questions and answers associated with the course.
     */
    public Course(String courseId, Prerequisite prerequisite, List<Question> questions) {
        this.courseId = courseId;
        this.prerequisite = prerequisite;
        this.questions = questions;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public Prerequisite getPrerequisite() {
        return this.prerequisite;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public Question getQuestionAt(int i) {
        return this.questions.get(i);
    }

    @Override
    public Iterator<Question> iterator() {
        return this.questions.iterator();
    }
}
