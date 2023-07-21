package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.Map;
import java.util.HashMap;

class StudentTest {
    @Test
    public void StudentNoCourses() {
        Map<String, Integer> courses = new HashMap<String, Integer>();
        Student student = new Student("JP", courses);
        Assertions.assertEquals("JP", student.getStudentId());
    }
}