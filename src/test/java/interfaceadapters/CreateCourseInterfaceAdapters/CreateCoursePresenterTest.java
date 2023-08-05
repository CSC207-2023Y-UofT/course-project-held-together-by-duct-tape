package interfaceadapters.CreateCourseInterfaceAdapters;

import frameworksdrivers.DatabaseDriver;
import frameworksdriversmock.CourseDbGatewayMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.InstructorCreateCourseUseCase.CreateCourseResponseModel;

import static org.junit.jupiter.api.Assertions.*;

class CreateCoursePresenterTest {

    private CreateCoursePresenter presenter;
    private CourseDbGatewayMock courseDbGatewayMock;

    @BeforeEach
    void setUp() {
        courseDbGatewayMock = new CourseDbGatewayMock();
        DatabaseDriver driver =
                new DatabaseDriver(courseDbGatewayMock);
        presenter = new CreateCoursePresenter(driver);
    }

    @Test
    void testCourseCreated() {
        // Define test data
        String courseId = "CSC123";
        CreateCourseResponseModel response = new CreateCourseResponseModel(courseId);

        // Test successful course creation
        Exception exception = assertThrows(SuccessCreate.class, () -> presenter.courseCreated(response));
        assertEquals("You created the course " + courseId, exception.getMessage());
    }

    @Test
    void testShowError() {
        // Define test error message
        String errorMessage = "Failed to create course";

        // Test error scenario
        Exception exception = assertThrows(FailedtoCreate.class, () -> presenter.showError(errorMessage));
        assertEquals(errorMessage, exception.getMessage());
    }


}
