package entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class PrerequisiteFactoryTest {


    @Test
    public void TestPrereqFactoryGeneric(){
        Prerequisite prerequisite = PrerequisiteFactory.create("Csc207", 85);
        Prerequisite prerequisite2 = PrerequisiteFactory.create("", 0);
        assertEquals("Csc207", prerequisite.getCourse() );
        assertEquals(85, prerequisite.getGpa() );
        assertTrue(prerequisite2.isEmpty() );}}

