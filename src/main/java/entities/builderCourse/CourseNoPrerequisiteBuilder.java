package entities.builderCourse;

import entities.Course;
import entities.Prerequisite;
import entities.Question;
import entities.QuestionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This builder implements the CourseBuilder and sets attributes as the input parameters of creation. Whenever this
 * builder is created, it must have the courseID, the questions, the answers, and the points. The prerequisite is
 * set to empty with a default of zero grade.
 */
public class CourseNoPrerequisiteBuilder implements CourseBuilder {
    private final Course course;
    private final List<String> questions;
    private final List<String> answers;
    private final List<Integer> points;

    public CourseNoPrerequisiteBuilder(String courseID, List<String> questions, List<String> answers, List<Integer> points) {
        course = new Course(courseID);
        this.questions = questions;
        this.answers = answers;
        this.points = points;
    }

    @Override
    public void buildQuestions() {
        List<Question> courseQuestions = new ArrayList<Question>();
        for (int j = 0; j < questions.size(); j++){
            courseQuestions.add(QuestionFactory.create(questions.get(j), answers.get(j), points.get(j)));
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
