package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrerequisiteTest {
    @Test
    public void TestPrereqConstructor(){
        Prerequisite prerequisite = new Prerequisite("Csc148", 90);
        Prerequisite emptyPrequisite = new Prerequisite("", 0);
        assertEquals(90, prerequisite.getGpa());
        assertEquals("Csc148", prerequisite.getCourse());
        assertTrue(emptyPrequisite.isEmpty());
    }
}