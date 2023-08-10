package entities.CourseBuilder;

import entities.Course;
import entities.Prerequisite;
import entities.Question;
import entities.QuestionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This builder implements the CourseBuilder and sets attributes as the input parameters of creation. Whenever this
 * builder is created, it must have the courseID, the questions, the answers, the points, and the prerequisite. The
 * prerequisite grade has a default of zero.
 */
public class CourseNoPrerequisiteGradeBuilder implements CourseBuilder {
    private final Course course;
    private final List<String> questions;
    private final List<String> answers;
    private final List<Integer> points;
    private final String prerequisite;

    public CourseNoPrerequisiteGradeBuilder(String courseID, List<String> questions, List<String> answers, List<Integer> points, String prerequisite) {
        course = new Course(courseID);
        this.questions = questions;
        this.answers = answers;
        this.points = points;
        this.prerequisite = prerequisite;
    }

    @Override
    public void buildQuestions() {
        List<Question> courseQuestions = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++){
            courseQuestions.add(QuestionFactory.create(questions.get(i), answers.get(i), points.get(i)));
        }
        course.setQuestions(courseQuestions);
    }

    public void buildPrerequisite() {
        Prerequisite prerequisite = new Prerequisite(this.prerequisite, 0);
        course.setPrerequisite(prerequisite);
    }

    @Override
    public Course getProduct() {
        return course;
    }
}
