package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuestionTest {

    @Test
    public void testQuestionNoAnswer() {
        Question question = new Question("What is 2 + 2?", "", 5);

        Assertions.assertEquals(question.getQuestion(), "What is 2 + 2?");
        Assertions.assertEquals(question.getAnswer(), "");
        Assertions.assertEquals(question.getPoints(), 5);
    }
}