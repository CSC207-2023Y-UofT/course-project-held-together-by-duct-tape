package csc207.entities;
import java.util.HashMap;
import java.util.List;
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
    public Student create(String studentId, List<String> courses, List<Integer> grades) {
        Map<String, Integer> courseMap = new HashMap<>();
        for (int j = 0; j < courses.size(); j++) {
            courseMap.put(courses.get(j), grades.get(j));
        }
        return new Student(studentId, courseMap);
    }
}
