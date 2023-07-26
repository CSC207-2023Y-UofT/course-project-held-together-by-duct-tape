package entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class PrerequisiteFactoryTest {
    private PrerequisiteFactory factory;
    @BeforeEach
    public void init(){ factory = new PrerequisiteFactory();}
    @Test
    public void TestPrereqFactoryGeneric(){
        Prerequisite prerequisite = factory.create("Csc207", 85);
        Prerequisite prerequisite2 = factory.create("", 0);
        assertEquals("Csc207", prerequisite.getCourse() );
        assertEquals(85, prerequisite.getGpa() );
        assertEquals(true, prerequisite2.isEmpty() );}}

