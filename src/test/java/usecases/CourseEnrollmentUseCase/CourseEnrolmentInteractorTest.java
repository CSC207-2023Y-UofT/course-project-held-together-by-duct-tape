package usecases.CourseEnrollmentUseCase;

import frameworksdrivers.CourseDbGatewayMock;
import frameworksdrivers.SessionDbGatewayMock;
import interfaceadapters.CourseEnrollmentInterfaceAdapters.EnrolmentPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class CourseEnrolmentInteractorTest {

    public EnrolmentRequestModel requestModel;
    public EnrolmentResponseModel responseModel;
    public CourseEnrolmentInteractor interactor;

    @BeforeEach
    public void init() {
        EnrolmentSessionDataAccess sessionDbGateway = new SessionDbGatewayMock();
        EnrolmentCourseDataAccess courseDbGateway = new CourseDbGatewayMock();

        CheckPrerequisitesInteractor completedPrerequisites = new CheckPrerequisitesInteractor(sessionDbGateway);
        EnrolmentOutputBoundary presenter = new EnrolmentPresenter(courseDbGateway);

        interactor = new CourseEnrolmentInteractor(courseDbGateway, completedPrerequisites, sessionDbGateway, presenter);

        requestModel = new EnrolmentRequestModel("CSC207");
        responseModel = new EnrolmentResponseModel("CSC207");
    }

    @Test
    public void testEnrol() {
        assertEquals(interactor.enrol(requestModel), "You've successfully enrolled in course " + responseModel.getCourseId());
    }
}