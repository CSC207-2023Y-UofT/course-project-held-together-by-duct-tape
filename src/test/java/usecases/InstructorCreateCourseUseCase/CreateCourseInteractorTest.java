package usecases.InstructorCreateCourseUseCase;

        import frameworksdriversmock.CourseDbGatewayMock;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.*;

class CreateCourseInteractorTest {

    private CreateCourseInteractor interactor;
    private CourseDbGatewayMock courseDbGatewayMock;

    @BeforeEach
    void setUp() {
        courseDbGatewayMock = new CourseDbGatewayMock();
        interactor = new CreateCourseInteractor(courseDbGatewayMock, null);
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
        interactor.createCourse(request);

        // Check if the course was added to the mock gateway
        assertTrue(courseDbGatewayMock.existsByCourseId(courseId));
        assertEquals(prerequisiteGrade, courseDbGatewayMock.getPrerequisiteGrade(courseId));
        assertEquals(questions, courseDbGatewayMock.getQuestions(courseId));
        assertEquals(answers, courseDbGatewayMock.getAnswers(courseId));
        assertEquals(points, courseDbGatewayMock.getPoints(courseId));
    }

    @Test
    void testCreateCourseWithPrerequisite() {
        // Define test data
        String courseId = "CSC223";
        String prerequisite = "CSC123";
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
        interactor.createCourse(request);

        // Check if the course and its prerequisite were added to the mock gateway
        assertTrue(courseDbGatewayMock.existsByCourseId(courseId));
        assertTrue(courseDbGatewayMock.existsByCourseId(prerequisite));
        assertEquals(prerequisiteGrade, courseDbGatewayMock.getPrerequisiteGrade(courseId));
        assertEquals(questions, courseDbGatewayMock.getQuestions(courseId));
        assertEquals(answers, courseDbGatewayMock.getAnswers(courseId));
        assertEquals(points, courseDbGatewayMock.getPoints(courseId));
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
        assertThrows(RuntimeException.class, () -> interactor.createCourse(request));
    }


}
