package usecases.CourseEnrollmentUseCase;

import frameworksdriversmock.SessionDbGatewayMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the CheckPrerequisitesInteractor
 */
class CheckPrerequisitesInteractorTest {
    private CheckPrerequisitesInteractor prerequisitesInteractor;

    /**
     * Initializes the checkPrerequisites interactor before each test.
     */
    @BeforeEach
    public void init() {
        SessionDbGatewayMock sessionDbGateway = new SessionDbGatewayMock();
        this.prerequisitesInteractor = new CheckPrerequisitesInteractor(sessionDbGateway);
    }

    /**
     * Checks whether prerequisitesInteractor.checkPrerequisite returns true if the course does not have prerequisites.
     */
    @Test
    public void testEmptyPrerequisites() {
        EnrolmentDbRequestModel requestModel = new EnrolmentDbRequestModel("CSC207");
        requestModel.setPrerequisiteID("");

        Assertions.assertTrue(prerequisitesInteractor.checkPrerequisite(requestModel));
    }

    /**
     * Checks whether the interactor returns false if the student does not have the required minimum grade for the
     * prerequisite course.
     */
    @Test
    public void testInsufficientGradePrerequisites() {
        EnrolmentDbRequestModel requestModel = new EnrolmentDbRequestModel("CSC207");
        requestModel.setPrerequisiteID("CSC148");
        requestModel.setPrerequisiteGrade(50f);

        Assertions.assertFalse(prerequisitesInteractor.checkPrerequisite(requestModel));
    }

    /**
     * Checks whether the interactor returns false if the student has not taken the prerequisite course.
     */
    @Test
    public void testUncompletedPrerequisiteCourse() {
        EnrolmentDbRequestModel requestModel = new EnrolmentDbRequestModel("CSC263");
        requestModel.setPrerequisiteID("STA257");
        requestModel.setPrerequisiteGrade(50f);

        Assertions.assertFalse(prerequisitesInteractor.checkPrerequisite(requestModel));
    }

    /**
     * Checks whether the interactor returns true if the student has completed the prerequisites for a course.
     */
    @Test
    public void testCompletedPrerequisites() {
        EnrolmentDbRequestModel requestModel = new EnrolmentDbRequestModel("CSC148");
        requestModel.setPrerequisiteID("CSC108");
        requestModel.setPrerequisiteGrade(50f);

        Assertions.assertTrue(prerequisitesInteractor.checkPrerequisite(requestModel));
    }
}