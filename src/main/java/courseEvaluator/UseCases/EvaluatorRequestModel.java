package courseEvaluator.UseCases;

import entities.Student;

public class EvaluatorRequestModel {
    private final Student studentId;
    private final String courseId;

    private final int grade;
    public EvaluatorRequestModel(Student studentId, String courseId, int grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Student getStudentId() {
        return studentId;
    }
    public String getCourseId() {
        return courseId;
    }


    public int getGrade() {
        return grade;
    }
}

