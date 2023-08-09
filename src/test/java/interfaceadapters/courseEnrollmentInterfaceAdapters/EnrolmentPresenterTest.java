package interfaceadapters.courseEnrollmentInterfaceAdapters;

import frameworksdriversmock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.courseEnrollmentUseCase.EnrolmentResponseModel;
import static org.junit.Assert.assertThrows;

/**
 * Test class for the course enrollment presenter
 */
public class EnrolmentPresenterTest {
    private final DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
    private EnrolmentPresenter enrolmentPresenter;

    @BeforeEach
    public void init() {
        this.enrolmentPresenter = new EnrolmentPresenter(databaseDriver);
    }

    /**
     * Test success view message
     */
    @Test
    public void testSuccessView() {
        EnrolmentResponseModel responseModel = new EnrolmentResponseModel("CSC148");
        Assertions.assertEquals(enrolmentPresenter.prepareSuccessView(responseModel), "You've successfully " +
                "enrolled in course CSC148");
    }

    /**
     * Test fail view message for nonexistent course ID
     */
    @Test
    public void testFailViewNonexistentCourse() {
        String message = "Course ID does not exist in Database!";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            enrolmentPresenter.prepareFailView(message);
        });
        Assertions.assertTrue(exception.getMessage().contains(message));
    }

    /**
     * Test fail view message for incomplete prerequisites
     */
    @Test
    public void testFailViewUncompletedPrerequisites() {
        String message = "You have not completed the prerequisites for the course.\nPrerequisite: CSC148 Grade: 50.0";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            enrolmentPresenter.prepareFailView(message);
        });
        Assertions.assertTrue(exception.getMessage().contains(message));
    }
}
