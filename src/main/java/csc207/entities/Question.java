package csc207.entities;

/**
 * A question for a course. It has a text for the question, answer, and has
 * a specified number of points that are rewarded if answered correctly.
 */
public class Question {
    private final String question;
    private final String answer;
    private final int points;

    /**
     * Construct a question with the answer and specified number of points.
     *
     * @param question the question asked.
     * @param answer the answer.
     * @param points the number of points for this question.
     */
    public Question(String question, String answer, int points) {
        this.question = question;
        this.answer = answer;
        this.points = points;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int getPoints() {
        return this.points;
    }
}
