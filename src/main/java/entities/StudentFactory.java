package entities;
import java.util.Map;

public class StudentFactory {

    /**
     * Builds a new student with their unique studentId, as well as the map of the
     * courses that they have completed with the grades per course.
     *
     * @param studentId the student id of the student.
     * @param courses the courses dictionary with courseId, grade as key, value pair.
     * @return Student object.
     */
    public Student create(String studentId, Map<Course, Integer> courses) {
        return new Student(studentId, courses);
    }
}
