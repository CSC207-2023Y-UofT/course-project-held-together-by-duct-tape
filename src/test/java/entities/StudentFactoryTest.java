package entities;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

class StudentFactoryTest {
    String[] courses;
    Float[] grades;

    StudentFactory factory;
    @BeforeEach
    public void init() {
        courses = new String[]{"Csc207", "Csc148", "Csc108"};
        grades = new Float[]{80f, 89f, 90f};
        factory = new StudentFactory();}
    @Test
    public void TestStudentFactoryGeneric(){
        Student student = factory.create("Nour", List.of(courses), List.of(grades));
        assertEquals("Nour", student.getStudentId());}}