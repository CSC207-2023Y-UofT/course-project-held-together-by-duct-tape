package interfaceadapters.RunCourseInterfaceAdapters;

import frameworksdriversmock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.RunCourseUseCase.RunCourseInteractor;
import java.util.ArrayList;
import java.util.List;

public class RunCourseControllerTest {

    private RunCourseController runCourseController;
    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        RunCoursePresenter coursePresenter = new RunCoursePresenter(databaseDriver);
        RunCourseInteractor runCourseInteractor = new RunCourseInteractor(databaseDriver.getSessionDbGatewayMock(), coursePresenter);

        this.runCourseController = new RunCourseController(runCourseInteractor);
    }
    @Test
    public void testControllerEmptyAnswer(){
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        questions.add("Question1");
        answers.add("");
        Assertions.assertEquals(runCourseController.runCourse(questions, answers), "Answers can not be empty.");
    }
    @Test
    public void testControllerMultipleEmptyAnswers(){
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        questions.add("Question1");
        answers.add("");
        questions.add("Question2");
        answers.add("");
        Assertions.assertEquals(runCourseController.runCourse(questions, answers), "Answers can not be empty.");
    }
    @Test
    public void testControllerValidAnswer(){
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        questions.add("Question1");
        answers.add("Answer");
        Assertions.assertEquals(runCourseController.runCourse(questions, answers), "Course Completed.");
    }
    @Test
    public void testAllValidAnswer(){
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        questions.add("Question1");
        answers.add("Answer");
        questions.add("Question2");
        answers.add("Answer");
        Assertions.assertEquals(runCourseController.runCourse(questions, answers), "Course Completed.");
    }
    @Test
    public void testControllerMixedAnswers(){
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        questions.add("Question1");
        answers.add("");
        questions.add("Question2");
        answers.add("Answer");
        questions.add("Question3");
        answers.add("");
        Assertions.assertEquals(runCourseController.runCourse(questions, answers), "Answers can not be empty.");
    }
}
