package entities;

public class Question {

    private final String question;
    private final String answer;
    private final int points;

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
