package entities.courseBuilder;

import entities.Course;
import entities.Prerequisite;
import entities.Question;
import entities.QuestionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This builder implements the CourseBuilder and sets attributes as the input parameters of creation. Whenever this
 * builder is created, it must have the courseID, the questions, the answers, the points, and both the prerequisite,
 * and the prerequisite grade.
 */
public class CourseFullBuilder implements CourseBuilder {
    private final Course course;
    private final List<String> questions;
    private final List<String> answers;
    private final List<Integer> points;
    private final String prerequisite;
    private final Float prerequisiteGrade;

    public CourseFullBuilder(String courseID, List<String> questions, List<String> answers, List<Integer> points,
                             String prerequisite, Float prerequisiteGrade) {
        course = new Course(courseID);
        this.questions = questions;
        this.answers = answers;
        this.points = points;
        this.prerequisite = prerequisite;
        this.prerequisiteGrade = prerequisiteGrade;
    }

    @Override
    public void buildQuestions() {
        List<Question> courseQuestions = new ArrayList<>();
        for (int j = 0; j < questions.size(); j++){
            courseQuestions.add(QuestionFactory.create(questions.get(j), answers.get(j), points.get(j)));
        }
        course.setQuestions(courseQuestions);
    }

    public void buildPrerequisite() {
        Prerequisite prerequisite = new Prerequisite(this.prerequisite, prerequisiteGrade);
        course.setPrerequisite(prerequisite);
    }

    @Override
    public Course getProduct() {
        return course;
    }
}
