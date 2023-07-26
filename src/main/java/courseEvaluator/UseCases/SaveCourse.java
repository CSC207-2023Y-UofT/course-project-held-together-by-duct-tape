package courseEvaluator.UseCases;

import entities.Student;

public class SaveCourse {

    private Student student;
    private String courseId;
    private int grade;

    public SaveCourse(String courseId, int grade, Student student){
        this.courseId = courseId;
        this.grade = grade;
        this.student = student;
    }
    public SaveCourse(Student student, String courseId, int grade){
        student.addCourse(courseId, grade);
    }
}
