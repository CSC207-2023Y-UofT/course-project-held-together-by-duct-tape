package interfaceadapters.courseEnrollmentInterfaceAdapters;

import frameworksdriversmock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.courseEnrollmentUseCase.CheckPrerequisitesInteractor;
import usecases.courseEnrollmentUseCase.CourseEnrolmentInteractor;
import usecases.courseEnrollmentUseCase.EnrolmentInputBoundary;
import java.util.ArrayList;
import static org.junit.Assert.assertThrows;

/**
 * Test class for the course enrollment controller. This tests the creation of a request model and the call made
 * to the interactor.
 */
class EnrolmentControllerTest {
    private EnrolmentController enrolmentController;
    /**
     * Initializes the controller before each test.
     */
    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        EnrolmentPresenter enrolmentPresenter = new EnrolmentPresenter(databaseDriver);
        CheckPrerequisitesInteractor completedPrerequisites = new
                CheckPrerequisitesInteractor(databaseDriver.getSessionDbGatewayMock());

        EnrolmentInputBoundary enrolmentInteractor = new CourseEnrolmentInteractor(databaseDriver.getCourseDbGatewayMock(),
                completedPrerequisites, databaseDriver.getSessionDbGatewayMock(), enrolmentPresenter);
        this.enrolmentController = new EnrolmentController(enrolmentInteractor);

        databaseDriver.getCourseDbGatewayMock().addCourse("CSC207", "CSC148", 50,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    /**
     * Tests whether the request model was created correctly, in order for it to be used by the interactor.
     */
    @Test
    public void testRequestModelCreation() {

        // Enrollment is successful
        Assertions.assertEquals("You've successfully enrolled in course CSC108",
                enrolmentController.enrol("CSC108"));

        // Enrollment is unsuccessful, because student does not have the prerequisites.
        Exception exception2 = assertThrows(RuntimeException.class, () -> {
            enrolmentController.enrol("CSC207");
        });
        Assertions.assertTrue(exception2.getMessage().contains("You have not completed the prerequisites " +
                "for the course.\nPrerequisite: CSC148 Grade: 50.0"));

        // Enrollment is unsuccessful, because course ID does not exist in database.
        Exception exception3 = assertThrows(RuntimeException.class, () -> {
            enrolmentController.enrol("CSC1110");
        });
        Assertions.assertTrue(exception3.getMessage().contains("Course ID does not exist in Database!"));

    }
}
