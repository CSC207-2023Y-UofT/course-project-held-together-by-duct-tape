package entities;
import java.util.List;

/**
 * Factory for creating Questions.
 */
public class QuestionFactory {

    /**
     * Builds a new question with the question text, answer text, and the points
     * associated with this question. This method is static since the CourseFactory
     * will call this method to create questions for the course.
     *
     * @param question this questions text.
     * @param answer the answer to the question.
     * @param points the points associated with this question.
     * @return Question object.
     */
    public static Question create(String question, String answer, Integer points) {
        return new Question(question, answer, points);
    }
}
