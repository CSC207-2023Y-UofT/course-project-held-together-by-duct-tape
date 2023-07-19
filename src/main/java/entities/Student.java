package entities;
import java.util.Map;

/**
 * A Student that has a unique student id. Has a map of courses that they
 * have successfully completed with the grade they obtained on that course.
 */
public class Student {
    private final String studentId;
    private final Map<String, Integer> courses;

    /**
     * Construct a Student with studentId of ID, as well as their courses
     * taken with courses.
     *
     * @param Id the unique student Id.
     * @param courses the courses the student has completed with grades.
     */
    public Student(String Id, Map<String, Integer> courses) {
        this.studentId = Id;
        this.courses = courses;
    }

    /**
     * Add a new course that this student has successfully completed with their
     * respective grade.
     *
     * @param course the new course the student has completed.
     * @param gpa the grade that is associated with this course.
     */
    public void addCourse(String course, Integer gpa) {
        this.courses.put(course, gpa);
    }

    public String getStudentId() {
        return this.studentId;
    }

    public Map<String, Integer> getCourses() {
        return this.courses;
    }
}