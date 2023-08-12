package interfaceAdapters.createCourseInterfaceAdapters;

import frameworksDriversMock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import useCases.createCourseUseCase.CreateCourseInteractor;
import useCases.createCourseUseCase.CreateCourseInputBoundary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CreateCourseControllerTest {

    private CreateCourseInputBoundary interactor;
    private CreateCourseController controller;

    @BeforeEach
    void setUp() {
        // Create a mock implementation for DatabaseDriver
        DatabaseDriverMock databaseDriverMock = new DatabaseDriverMock();

        // Create an instance of CreateCourseInteractor using the mock implementations
        CreateCoursePresenter presenter = new CreateCoursePresenter(databaseDriverMock);
        interactor = new CreateCourseInteractor(databaseDriverMock.getCourseDbGatewayMock(), presenter);

        // Create an instance of CreateCourseController
        controller = new CreateCourseController(interactor);
    }


    @Test
    void testCreateCourse_Success() {
        String courseId = "CSC128";
        String prerequisite = "";
        String prerequisiteGrade = "";
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is the meaning of life?");
        answers.add("42");
        points.add(10);

        Assertions.assertEquals(controller.createCourse(courseId, prerequisite,
                prerequisiteGrade, questions, answers, points), "You created the course " + courseId);
    }

    @Test
    void testCreateCourse_Failed_CourseExists() {
        // Arrange
        String courseId = "CSC108";
        String prerequisite = "CSC100";
        String prerequisiteGrade = "80.0";
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is the capital of France?");
        answers.add("Paris");
        points.add(10);

        // Act and Assert
        try {
            controller.createCourse(courseId, prerequisite, prerequisiteGrade, questions, answers, points);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(),
                    "Course with this name already exists, Or you gave an empty input.");
        }
    }

    @Test
    void testCreateCourse_Failed_PrerequisiteNotFound() {
        String courseId = "CSC209";
        String prerequisite = "CSC207";
        String prerequisiteGrade = "70.0";
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is the meaning of life?");
        answers.add("42");
        points.add(10);

        try {
            controller.createCourse(courseId, prerequisite, prerequisiteGrade, questions, answers, points);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "Prerequisite course not found in the database.");
        }
    }

    @Test
    void testCreateCourse_Failed_NegativePrerequisiteGrade() {
        String courseId = "CSC209";
        String prerequisite = "CSC108";
        String prerequisiteGrade = "-70.0";
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is the meaning of life?");
        answers.add("42");
        points.add(10);

        try {
            controller.createCourse(courseId, prerequisite, prerequisiteGrade, questions, answers, points);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "Prerequisite's Grade must be positive numbers.");
        }
    }

    @Test
    void testCreateCourse_Failed_EmptyQuestion() {
        String courseId = "CSC209";
        String prerequisite = "CSC108";
        String prerequisiteGrade = "70.0";
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("");
        answers.add("42");
        points.add(10);

        try {
            controller.createCourse(courseId, prerequisite, prerequisiteGrade, questions, answers, points);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "All questions must be filled.");
        }
    }

    @Test
    void testCreateCourse_Failed_SuccessCreateException() {
        String courseId = "CSC209";
        String prerequisite = "CSC207";
        String prerequisiteGrade = "70.0";
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is the meaning of life?");
        answers.add("42");
        points.add(10);

        try {
            controller.createCourse(courseId, prerequisite, prerequisiteGrade, questions, answers, points);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "Prerequisite course not found in the database.");
        }
    }
}




