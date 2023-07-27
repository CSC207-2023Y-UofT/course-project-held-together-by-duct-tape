package usecases.CourseEnrollmentUseCase;

import interfaceadapters.CourseEnrollmentInterfaceAdapters.EnrolmentPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class CourseEnrolmentInteractorTest {

    public EnrolmentRequestModel requestModel;
    public EnrolmentResponseModel responseModel;

    @BeforeEach
    public void init() {
        // requestModel = new EnrolmentRequestModel("ade", "CSC207");
        // responseModel = new EnrolmentResponseModel("CSC207");
    }

    @Test
    public void testEnrol() {
        // COMMENTING OUT THIS TEST BECAUSE WE NEED TO CREATE MOCK GATEWAYS IN TEST

        // CourseDbGateway courseGateway = new CourseDbGateway();
        // SessionDbGateway sessionGateway = new SessionDbGateway();
        // CheckPrerequisitesInteractor completedPrerequisites = new CheckPrerequisitesInteractor(sessionGateway);
        // EnrolmentOutputBoundary presenter = new EnrolmentPresenter(courseGateway);

        // CourseEnrolmentInteractor interactor = new CourseEnrolmentInteractor(courseGateway, completedPrerequisites, sessionGateway, presenter);

        // assertEquals(interactor.enrol(requestModel), "You've successfully enrolled in course " + responseModel.getCourseId());
    }
}