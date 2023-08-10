package interfaceadapters.CreateCourseInterfaceAdapters;

import frameworksdriversmock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.InstructorCreateCourseUseCase.CreateCourseResponseModel;

class CreateCoursePresenterTest {

    private CreateCoursePresenter presenter;

    @BeforeEach
    void setUp() {
        DatabaseDriverMock driver = new DatabaseDriverMock();
        this.presenter = new CreateCoursePresenter(driver);
    }

    @Test
    void testCourseCreated() {
        // Define test data
        String courseId = "CSC123";
        CreateCourseResponseModel response = new CreateCourseResponseModel(courseId);

        // Test successful course creation
        Assertions.assertEquals(presenter.courseCreated(response), "You created the course " + courseId);
    }

    @Test
    void testShowError() {
        // Define test error message
        String errorMessage = "Failed to create course";

        // Test error scenario
        try {
            presenter.showError(errorMessage);
        } catch (FailedtoCreate e) {
            Assertions.assertEquals(errorMessage, e.getMessage());
        }
    }
}
