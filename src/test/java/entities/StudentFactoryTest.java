package entities;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

class StudentFactoryTest {
    String[] courses;
    Integer[] grades;

    StudentFactory factory;
    @BeforeEach
    public void init() {
        courses = new String[]{"Csc207", "Csc148", "Csc108"};
        grades = new Integer[]{80, 89, 90};
        factory = new StudentFactory();}
    @Test
    public void TestStudentFactoryGeneric(){
        Student student = factory.create("Nour", List.of(courses), List.of(grades));
        assertEquals("Nour", student.getStudentId());}}