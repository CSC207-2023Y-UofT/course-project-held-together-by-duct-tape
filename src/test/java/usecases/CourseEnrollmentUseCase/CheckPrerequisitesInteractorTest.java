package usecases.CourseEnrollmentUseCase;

import entities.Course;
import entities.Prerequisite;
import entities.Question;
import frameworksdrivers.SessionDbGatewayMock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


class CheckPrerequisitesInteractorTest {
    private CheckPrerequisitesInteractor interactor;
    private Course defaultCourse;

    @BeforeEach
    public void init() {
        List<Question> questions = new ArrayList<Question>();
        Question question = new Question("What is 2 + 2?", "4", 2);
        questions.add(question);

        Prerequisite prerequisite = new Prerequisite("CSC108", 0);

        this.defaultCourse = new Course("CSC207", prerequisite, questions);

        SessionDbGatewayMock sessionDbGateway = new SessionDbGatewayMock();

        this.interactor = new CheckPrerequisitesInteractor(sessionDbGateway);
    }

    @Test
    public void testEmptyPrerequisites() {
        List<Question> questions = new ArrayList<Question>();
        Prerequisite prerequisite = new Prerequisite("", 0);

        Course course = new Course("CSC207", prerequisite, questions);

        // Assertions.assertTrue(interactor.checkPrerequisite(course));
    }
}
