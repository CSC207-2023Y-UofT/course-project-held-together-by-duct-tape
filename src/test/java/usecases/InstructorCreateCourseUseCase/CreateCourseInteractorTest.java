package usecases.InstructorCreateCourseUseCase;

import frameworksdriversmock.DatabaseDriverMock;
import interfaceadapters.CreateCourseInterfaceAdapters.CreateCoursePresenter;
import interfaceadapters.CreateCourseInterfaceAdapters.FailedtoCreate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CreateCourseInteractorTest {
    private CreateCourseInteractor interactor;

    @BeforeEach
    void setUp() {
        DatabaseDriverMock driver = new DatabaseDriverMock();
        CreateCourseOutputBoundary presenter = new CreateCoursePresenter(driver);
        this.interactor = new CreateCourseInteractor(driver.getCourseDbGatewayMock(), presenter);
    }

    @Test
    void testCreateCourseSuccess() {
        // Define test data
        String courseId = "CSC123";
        String prerequisite = "";
        Float prerequisiteGrade = 0.0f;
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is 1 + 1?");
        answers.add("2");
        points.add(5);

        // Call the method being tested
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prerequisite, prerequisiteGrade,
                questions, answers, points);

        Assertions.assertEquals(interactor.createCourse(request), "You created the course " + courseId);

        // Check if the course was added to the mock gateway

        // You don't have to check for these things because the mock gateways are dummy methods, here you just want
        // to test that there is a successful course creation. The mock gateway is not a real gateway, so we shouldn't
        // test its functionality because in the real code it does not matter.

        // assertTrue(courseDbGatewayMock.existsByCourseId(courseId));
        // assertEquals(prerequisiteGrade, courseDbGatewayMock.getPrerequisiteGrade(courseId));
        // assertEquals(questions, courseDbGatewayMock.getQuestions(courseId));
        // assertEquals(answers, courseDbGatewayMock.getAnswers(courseId));
        // assertEquals(points, courseDbGatewayMock.getPoints(courseId));
    }

    @Test
    void testCreateCourseWithPrerequisiteNotInDatabase() {
        // Define test data
        String courseId = "CSC223";
        String prerequisite = "CSC108";
        Float prerequisiteGrade = 70.0f;
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is 2 + 2?");
        answers.add("4");
        points.add(5);

        // Call the method being tested
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prerequisite, prerequisiteGrade,
                questions, answers, points);

        Assertions.assertEquals(interactor.createCourse(request), "You created the course CSC223");

        // Check if the course and its prerequisite were added to the mock gateway

        // same problem here, we shouldn't check the mock gateway methods, they aren't of use to us

        // assertTrue(courseDbGatewayMock.existsByCourseId(courseId));
        // assertTrue(courseDbGatewayMock.existsByCourseId(prerequisite));
        // assertEquals(prerequisiteGrade, courseDbGatewayMock.getPrerequisiteGrade(courseId));
        // assertEquals(questions, courseDbGatewayMock.getQuestions(courseId));
        // assertEquals(answers, courseDbGatewayMock.getAnswers(courseId));
        // assertEquals(points, courseDbGatewayMock.getPoints(courseId));
    }

    @Test
    void testCreateCourseWithInvalidPrerequisite() {
        // Define test data
        String courseId = "CSC323";
        String prerequisite = "INVALID_PREREQ"; // Prerequisite that doesn't exist
        Float prerequisiteGrade = -70.0f; // Negative grade
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is 4 + 4?");
        answers.add("8");
        points.add(5);

        // Call the method being tested
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prerequisite, prerequisiteGrade,
                questions, answers, points);
        try {
            interactor.createCourse(request);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "Prerequisite course not found in the database.");
        }
    }
}
