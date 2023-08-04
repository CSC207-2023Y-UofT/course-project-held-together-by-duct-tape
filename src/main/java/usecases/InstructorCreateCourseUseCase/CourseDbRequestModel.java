package usecases.InstructorCreateCourseUseCase;

import entities.Course;

import java.util.*;

public class CourseDbRequestModel {
    // Define the data required to interact with the course database
    private final String courseId;
    private final String prereq;
    private final Float prereqGrade;
    private final List<String> questions;
    private final List<String> answers;
    private final List<Integer> points;

    public String getCourseId() {
        return courseId;
    }

    public String getPrereq() {
        return prereq;
    }

    public Float getPrereqGrade() {
        return prereqGrade;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public CourseDbRequestModel(String courseId, String prereq, Float prereqGrade, List<String> questions,
                                List<String> answers, List<Integer> points ){
        this.points = points;
        this.prereq = prereq;
        this.questions = questions;
        this.answers = answers;
        this.prereqGrade = prereqGrade;
        this.courseId = courseId;


    }

}
