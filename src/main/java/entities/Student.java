package entities;
import java.util.List;
import java.util.Map;

public class Student {

    private final String studentId;
    private CGPA cgpa;
    private final Map<Course, Integer> courses;

    public Student(String Id, Map<Course, Integer> courses) {
        this.studentId = Id;
        this.courses = courses;
        // this.cgpa = this.calculateCGPA();
    }

    public String getStudentId() {
        return this.studentId;
    }

    public Map<Course, Integer> getCourses() {
        return this.courses;
    }

    public CGPA getCgpa() {
        return this.cgpa;
    }

    public void addCourse(Course course, Integer gpa) {
        this.courses.put(course, gpa);
    }

    public void addCourses(List<Course> courses, List<Integer> grades) {
        for (int j = 0; j < courses.size(); j++) {
            this.addCourse(courses.get(j), grades.get(j));
        }
    }

//    private CGPA calculateCGPA() {
//        return CGPA();
//    }
}
