package usecases.RunCourseUseCase;
import frameworksdriversmock.DatabaseDriverMock;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentPresenter;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginUserFailed;
import interfaceadapters.RunCourseInterfaceAdapters.RunCoursePresenter;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Driver;

public class RunCourseInteractorTest {
    private RunCourseInteractor interactor;



    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        RunCoursePresenter coursePresenter = new RunCoursePresenter(databaseDriver);

        interactor = new RunCourseInteractor(databaseDriver.getSessionDbGateway(), coursePresenter);
    }

    @Test
    public void testEmptyAnswer() {
        List<String> questions = new ArrayList<String>();
        List<String> answers = new ArrayList<String>();
        questions.add("Question1");
        answers.add("");
        RunCourseRequestModel requestModel = new RunCourseRequestModel(questions, answers);
        Assertions.assertEquals(interactor.runCourse(requestModel), "Answers can not be empty.");
    }
    @Test
    public void testOneValidAnswer() {
        List<String> questions = new ArrayList<String>();
        List<String> answers = new ArrayList<String>();
        questions.add("Question1");
        answers.add("Answer");
        RunCourseRequestModel requestModel = new RunCourseRequestModel(questions, answers);
        Assertions.assertEquals(interactor.runCourse(requestModel), "Course Completed.");
    }
    @Test
    public void testOneEmptyAnswer() {
        List<String> questions = new ArrayList<String>();
        List<String> answers = new ArrayList<String>();
        questions.add("Question1");
        answers.add("Answer");
        questions.add("Question2");
        answers.add("");
        RunCourseRequestModel requestModel = new RunCourseRequestModel(questions, answers);
        Assertions.assertEquals(interactor.runCourse(requestModel), "Answers can not be empty.");
    }
    @Test
    public void testAllValidAnswer() {
        List<String> questions = new ArrayList<String>();
        List<String> answers = new ArrayList<String>();
        questions.add("Question1");
        answers.add("Answer");
        questions.add("Question2");
        answers.add("Answer");
        RunCourseRequestModel requestModel = new RunCourseRequestModel(questions, answers);
        Assertions.assertEquals(interactor.runCourse(requestModel), "Course Completed.");
    }
    @Test
    public void testSpaceAnswer() {
        List<String> questions = new ArrayList<String>();
        List<String> answers = new ArrayList<String>();
        questions.add("Question1");
        answers.add(" ");
        RunCourseRequestModel requestModel = new RunCourseRequestModel(questions, answers);
        Assertions.assertEquals(interactor.runCourse(requestModel), "Course Completed.");
    }
    @Test
    public void testInvalidAnswerAtStart() {
        List<String> questions = new ArrayList<String>();
        List<String> answers = new ArrayList<String>();
        questions.add("Question1");
        answers.add("");
        questions.add("Question2");
        answers.add("Answer");
        RunCourseRequestModel requestModel = new RunCourseRequestModel(questions, answers);
        Assertions.assertEquals(interactor.runCourse(requestModel), "Answers can not be empty.");
    }
}
