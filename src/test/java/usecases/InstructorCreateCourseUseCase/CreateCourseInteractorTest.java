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
    }

    @Test
    void testCreateCourseAlreadyExsitsCourseName(){
        String existingCourseId = "CSC108";
        String newCourseId = existingCourseId; // Attempting to create a course with an existing ID
        String prerequisite = "";
        Float prerequisiteGrade = 0.0f;
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is 1 + 1?");
        answers.add("2");
        points.add(5);

        // Call the method being tested
        CreateCourseRequestModel request = new CreateCourseRequestModel(newCourseId, prerequisite, prerequisiteGrade,
                questions, answers, points);

        try {
            interactor.createCourse(request);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(),
                    "Course with this name already exists, Or you gave an empty input.");
        }
    }

    @Test
    void testCreateCourseWithPrerequisiteNotInDatabase() {
        //Define test data
        String courseId = "CSC223";//new course name
        String prerequisite = "CSC108";//prereq that does not exsit in database
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
        try {
            interactor.createCourse(request);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "Prerequisite course not found in the database.");
        }

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
    @Test
    void testCreateCourseWithEmptyQuestions(){
        // Define test data
        String courseId = "CSC123";
        String prerequisite = "";
        Float prerequisiteGrade = 0.0f;
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        // Empty question
        questions.add("");
        answers.add("2");
        points.add(5);

        // Call the method being tested
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prerequisite, prerequisiteGrade,
                questions, answers, points);

        try {
            interactor.createCourse(request);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "All questions must be filled.");
        }
    }


    @Test
    void testCreateCourseWithEmptyAnswers() {
        // Define test data
        String courseId = "CSC123";
        String prerequisite = "";
        Float prerequisiteGrade = 0.0f;
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is 1 + 1?");
        // Empty answer
        answers.add("");
        points.add(5);

        // Call the method being tested
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prerequisite, prerequisiteGrade,
                questions, answers, points);

        try {
            interactor.createCourse(request);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "All answers must be filled.");
        }
    }

    @Test
    void testCreateCourseWithNegativePoints() {
        // Define test data
        String courseId = "CSC123";
        String prerequisite = "";
        Float prerequisiteGrade = 0.0f;
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is 1 + 1?");
        answers.add("2");
        // Negative points
        points.add(-5);

        // Call the method being tested
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prerequisite, prerequisiteGrade,
                questions, answers, points);

        try {
            interactor.createCourse(request);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(e.getMessage(), "Points must be positive for all questions.");
        }
    }
}
