package entities;
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
        return new Student(studentId, courseMap);}

    /**
    * Builds a new student with their unique studentId, as well as a map of the potential courses
     * they could take (all the grades in this course map would be set to null
     * @param courses the courses list that is used to set up an empty dictionary
     * @return Student object with no grades in its potential course list*/
    public Student create(String studentID, List<String> courses){
        Map<String, Integer> courseMap = new HashMap<>();
        for (int j = 0; j < courses.size(); j++) {
            courseMap.put(courses.get(j), null);}
        return new Student(studentID, courseMap);}}
