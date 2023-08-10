package entities.CourseBuilder;

import entities.Course;
import entities.Prerequisite;
import entities.Question;
import entities.QuestionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This builder implements the CourseBuilder and sets attributes as the input parameters of creation. Whenever this
 * builder is created, it must have the courseID, the questions, and the points. It sets the answers to be empty
 * as well as the prerequisites as empty.
 */
public class CourseNoAnswersOrPrerequisiteBuilder implements CourseBuilder {
    private final Course course;
    private final List<String> questions;
    private final List<Integer> points;

    public CourseNoAnswersOrPrerequisiteBuilder(String courseID, List<String> questions, List<Integer> points) {
        course = new Course(courseID);
        this.questions = questions;
        this.points = points;
    }

    @Override
    public void buildQuestions() {
        List<Question> courseQuestions = new ArrayList<>();
        for (int k = 0; k < questions.size(); k++){
            courseQuestions.add(QuestionFactory.create(questions.get(k), "", points.get(k)));
        }
        course.setQuestions(courseQuestions);
    }

    @Override
    public void buildPrerequisite() {
        Prerequisite prerequisite = new Prerequisite("", 0);
        course.setPrerequisite(prerequisite);
    }

    @Override
    public Course getProduct() {
        return course;
    }
}
