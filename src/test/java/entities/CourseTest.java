package entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CourseTest {
    Question[] questions;
    Course course;
    Prerequisite prereq;
    @BeforeEach
    public void init(){ questions = new Question[]{new Question("1+1", "2", 1),
    new Question("1+2", "3", 2), new Question("1+5", "6", 3)};
        prereq = new Prerequisite("Csc108", 50);
        course = new Course("Csc148", prereq, List.of(questions));}



    @Test
    public void TestCourseConstructor(){
        assertEquals("Csc148", course.getCourseId());
        assertEquals(prereq.getCourse(), course.getPrerequisite().getCourse());
        assertEquals(questions[0].getAnswer(), course.getQuestions().get(0).getAnswer());}}