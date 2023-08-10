package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;
import java.util.HashMap;

class StudentTest {
    Student student;
    Map<String, Float> courses;
    @BeforeEach
    public void init() {
        courses = new HashMap<>();
        student = new Student("JP", courses);}

    @Test
    public void testStudentNoCourses() {
        Assertions.assertEquals("JP", student.getStudentId());
    }
}