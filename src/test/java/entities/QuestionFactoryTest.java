package entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class QuestionFactoryTest {
    private QuestionFactory factory;
    @BeforeEach
    public void init(){ factory = new QuestionFactory();}
    @Test
    public void TestQuestionFactoryGeneric() {
        Question question = factory.create("1+2", "3", 1);
        assertEquals("1+2", question.getQuestion());
        assertEquals("3", question.getAnswer());
        assertEquals(1, question.getPoints());}}