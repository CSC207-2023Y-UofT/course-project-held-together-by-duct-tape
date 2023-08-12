package useCases.courseEvaluatorUseCase;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckAnswersTest {
    private EvaluatorDbResponseModel courseResponse;
    private EvaluatorDbResponseModel studentResponse;

    @BeforeEach
    public void init() {
        studentResponse = new EvaluatorDbResponseModel("CSC108");
        courseResponse = new EvaluatorDbResponseModel("CSC108");

    }
    @Test
    public void allWrong() {
        List<String> questions = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        List<String> studentAnswers = new ArrayList<>();

        questions.add("what is 1+1?");
        questions.add("what is 2 + 2?");
        correctAnswers.add("2");
        correctAnswers.add("4");
        studentAnswers.add("11");
        studentAnswers.add("22");
        points.add(1);
        points.add(1);
        courseResponse.setQuestions(questions);
        studentResponse.setQuestions(questions);
        courseResponse.setAnswers(correctAnswers);
        studentResponse.setAnswers(studentAnswers);
        courseResponse.setPoints(points);
        studentResponse.setPoints(points);

        Assertions.assertEquals(CheckAnswer.compare(studentResponse, courseResponse), 0.0f);

    }
    @Test
    public void allCorrect() {
        List<String> questions = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        List<String> studentAnswers = new ArrayList<>();

        questions.add("what is 1+1?");
        questions.add("what is 2 + 2?");
        correctAnswers.add("2");
        correctAnswers.add("4");
        studentAnswers.add("2");
        studentAnswers.add("4");
        points.add(1);
        points.add(1);
        courseResponse.setQuestions(questions);
        studentResponse.setQuestions(questions);
        courseResponse.setAnswers(correctAnswers);
        studentResponse.setAnswers(studentAnswers);
        courseResponse.setPoints(points);
        studentResponse.setPoints(points);

        Assertions.assertEquals(CheckAnswer.compare(studentResponse, courseResponse), 100.0f);

    }
    @Test
    public void partialMarks() {
        List<String> questions = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        List<String> studentAnswers = new ArrayList<>();

        questions.add("what is 1+1?");
        questions.add("what is 2 + 2?");
        correctAnswers.add("2");
        correctAnswers.add("4");
        studentAnswers.add("2");
        studentAnswers.add("22");
        points.add(1);
        points.add(1);
        courseResponse.setQuestions(questions);
        studentResponse.setQuestions(questions);
        courseResponse.setAnswers(correctAnswers);
        studentResponse.setAnswers(studentAnswers);
        courseResponse.setPoints(points);
        studentResponse.setPoints(points);

        Assertions.assertEquals(CheckAnswer.compare(studentResponse, courseResponse), 50.0f);
    }

}
