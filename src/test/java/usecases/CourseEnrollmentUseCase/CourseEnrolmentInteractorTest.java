package usecases.CourseEnrollmentUseCase;

import interfaceadapters.CourseEnrollmentInterfaceAdapters.EnrolmentPresenter;
import frameworksdrivers.CourseDbGateway;
import frameworksdrivers.SessionDbGateway;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class CourseEnrolmentInteractorTest {
    @Test
    public void testEnrol() {
        EnrolmentRequestModel requestModel = new EnrolmentRequestModel("ade", "CSC207");
        EnrolmentResponseModel responseModel = new EnrolmentResponseModel("CSC207");

        EnrolmentCourseDataAccess courseGateway = new CourseDbGateway();
        EnrolmentDataAccess sessionGateway = new SessionDbGateway();
        CheckPrerequisitesInteractor completedPrerequisites = new CheckPrerequisitesInteractor(sessionGateway);
        EnrolmentOutputBoundary presenter = new EnrolmentPresenter();

        CourseEnrolmentInteractor interactor = new CourseEnrolmentInteractor(courseGateway,
                completedPrerequisites, sessionGateway, presenter);

        assertEquals(interactor.enrol(requestModel), "You've successfully enrolled in course " +
                responseModel.getCourseId());
    }
}