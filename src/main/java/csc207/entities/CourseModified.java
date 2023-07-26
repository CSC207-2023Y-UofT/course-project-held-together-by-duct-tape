package csc207.entities;

import java.util.Iterator;
import java.util.List;

/**
 * A course with a unique course id and prerequisite. There are associated
 * questions and answers.
 */
public class CourseModified implements Iterable<Question>{
    private final String courseId;
    private final List<Prerequisite> prerequisites;
    private final List<Question> questions;

    /**
     * Construct a course with courseId, prerequisite and a list of questions.
     *
     * @param courseId the unique course Id.
     * @param prerequisites the list of prerequisites to take this course.
     * @param questions the list of questions and answers associated with the course.
     */
    public CourseModified(String courseId, List<Prerequisite> prerequisites, List<Question> questions) {
        this.courseId = courseId;
        this.prerequisites = prerequisites;
        this.questions = questions;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public List<Prerequisite> getPrerequisites() {
        return this.prerequisites;
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
