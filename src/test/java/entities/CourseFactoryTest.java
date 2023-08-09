package entities;

import entities.builderCourse.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CourseFactoryTest {
    List<String>  questions;
    List<String> answers;
    List<Integer> points;

    @BeforeEach
    public void init(){
        questions = new ArrayList<>();
        questions.add("1+2");
        questions.add("1+1");
        questions.add("1+3");
        answers = new ArrayList<>();
        answers.add("3");
        answers.add("2");
        answers.add("5");
        points = new ArrayList<>();
        points.add(1);
        points.add(2);
        points.add(3);
    }
    @Test
    public void TestCourseFactoryCourseFullBuilder() {
        CourseBuilder courseBuilder = new CourseFullBuilder("Math", questions, answers,
                points, "Grade1", 50f);
        CourseFactory courseFactory = new CourseFactory(courseBuilder);
        courseFactory.create();
        Course course = courseBuilder.getProduct();

        Assertions.assertEquals(course.getCourseId(), "Math");
        Assertions.assertEquals(course.getPrerequisite().getCourse(), "Grade1");
        Assertions.assertEquals(course.getPrerequisite().getGpa(), 50f);
        Assertions.assertEquals(course.getQuestionAt(0).getQuestion(), "1+2");
        Assertions.assertEquals(course.getQuestionAt(0).getAnswer(), "3");
        Assertions.assertEquals(course.getQuestionAt(0).getPoints(), 1);
        Assertions.assertEquals(course.getAllPoints(), 6);
    }

    @Test
    public void TestCourseFactoryCourseNoPrerequisiteBuilder() {
        CourseBuilder courseBuilder = new CourseNoPrerequisiteBuilder("Math", questions, answers, points);
        CourseFactory courseFactory = new CourseFactory(courseBuilder);
        courseFactory.create();
        Course course = courseBuilder.getProduct();

        Assertions.assertEquals(course.getCourseId(), "Math");
        Assertions.assertEquals(course.getPrerequisite().getCourse(), "");
        Assertions.assertEquals(course.getPrerequisite().getGpa(), 0f);
        Assertions.assertEquals(course.getQuestionAt(0).getQuestion(), "1+2");
        Assertions.assertEquals(course.getQuestionAt(0).getAnswer(), "3");
        Assertions.assertEquals(course.getQuestionAt(0).getPoints(), 1);
        Assertions.assertEquals(course.getAllPoints(), 6);
    }

    @Test
    public void TestCourseFactoryCourseNoPrerequisiteGradeBuilder() {
        CourseBuilder courseBuilder = new CourseNoPrerequisiteGradeBuilder("Math", questions, answers,
                points, "Grade1");
        CourseFactory courseFactory = new CourseFactory(courseBuilder);
        courseFactory.create();
        Course course = courseBuilder.getProduct();

        Assertions.assertEquals(course.getCourseId(), "Math");
        Assertions.assertEquals(course.getPrerequisite().getCourse(), "Grade1");
        Assertions.assertEquals(course.getPrerequisite().getGpa(), 0f);
        Assertions.assertEquals(course.getQuestionAt(0).getQuestion(), "1+2");
        Assertions.assertEquals(course.getQuestionAt(0).getAnswer(), "3");
        Assertions.assertEquals(course.getQuestionAt(0).getPoints(), 1);
        Assertions.assertEquals(course.getAllPoints(), 6);
    }

    @Test
    public void TestCourseFactoryCourseNoAnswersOrPrerequisiteBuilder() {
        CourseBuilder courseBuilder = new CourseNoAnswersOrPrerequisiteBuilder("Math", questions, points);
        CourseFactory courseFactory = new CourseFactory(courseBuilder);
        courseFactory.create();
        Course course = courseBuilder.getProduct();

        Assertions.assertEquals(course.getCourseId(), "Math");
        Assertions.assertEquals(course.getPrerequisite().getCourse(), "");
        Assertions.assertEquals(course.getPrerequisite().getGpa(), 0f);
        Assertions.assertEquals(course.getQuestionAt(0).getQuestion(), "1+2");
        Assertions.assertEquals(course.getQuestionAt(0).getAnswer(), "");
        Assertions.assertEquals(course.getQuestionAt(0).getPoints(), 1);
        Assertions.assertEquals(course.getAllPoints(), 6);
    }
}
