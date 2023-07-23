package entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseFactoryTest {
    CourseFactory factory;
    String[] questions;
    String[] answers;

    Integer[] points;
    @BeforeEach
    public void init(){
        factory = new CourseFactory();
        questions = new String[]{"1+2", "1+1", "1+4"};
        answers = new String[]{"3", "2", "5"};
        points = new Integer[]{1,2,3};

    }
    @Test
    public void TestCourseFactoryAllparameters(){
        Course course =factory.create("Csc207", "Csc148", 70, List.of(questions),
                List.of(answers), List.of(points) );
        assertEquals("Csc207", course.getCourseId());
        assertEquals("Csc148", course.getPrerequisite().getCourse());
        assertEquals(70, course.getPrerequisite().getGpa());
        assertEquals(answers[0], course.getQuestionAt(0).getAnswer());
        assertEquals(answers[1], course.getQuestionAt(1).getAnswer());
        assertEquals(answers[2], course.getQuestionAt(2).getAnswer());
        assertEquals(questions[0], course.getQuestionAt(0).getQuestion());
        assertEquals(questions[1], course.getQuestionAt(1).getQuestion());
        assertEquals(questions[2], course.getQuestionAt(2).getQuestion());}

    @Test
    public void TestCourseFactoryNoPrereqGrade(){
        Course course =factory.create("Csc207", "Csc148", List.of(questions), List.of(answers),
                List.of(points));
        assertEquals("Csc207", course.getCourseId());
        assertEquals("Csc148", course.getPrerequisite().getCourse());
        assertEquals(50, course.getPrerequisite().getGpa());
        assertEquals(answers[0], course.getQuestionAt(0).getAnswer());
        assertEquals(answers[1], course.getQuestionAt(1).getAnswer());
        assertEquals(answers[2], course.getQuestionAt(2).getAnswer());
        assertEquals(questions[0], course.getQuestionAt(0).getQuestion());
        assertEquals(questions[1], course.getQuestionAt(1).getQuestion());
        assertEquals(questions[2], course.getQuestionAt(2).getQuestion());}

    @Test
    public void TestCourseFactoryNoPrereq(){
        Course course =factory.create("Csc207", List.of(questions), List.of(answers),
                List.of(points));
        assertEquals("Csc207", course.getCourseId());
        assertEquals("", course.getPrerequisite().getCourse());
        assertEquals(0, course.getPrerequisite().getGpa());
        assertEquals(answers[0], course.getQuestionAt(0).getAnswer());
        assertEquals(answers[1], course.getQuestionAt(1).getAnswer());
        assertEquals(answers[2], course.getQuestionAt(2).getAnswer());
        assertEquals(questions[0], course.getQuestionAt(0).getQuestion());
        assertEquals(questions[1], course.getQuestionAt(1).getQuestion());
        assertEquals(questions[2], course.getQuestionAt(2).getQuestion());}
    }
