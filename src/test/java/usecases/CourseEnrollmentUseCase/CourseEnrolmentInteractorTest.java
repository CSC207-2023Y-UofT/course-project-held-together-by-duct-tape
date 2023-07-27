package usecases.CourseEnrollmentUseCase;

import interfaceadapters.CourseEnrollmentInterfaceAdapters.EnrolmentPresenter;
import entities.Question;
import frameworksdrivers.CourseDbGateway;
import frameworksdrivers.SessionDbGateway;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CourseEnrolmentInteractorTest {
    @Test
    public void testEnrol() {
        ArrayList<Question> questions = new ArrayList<Question>();
        EnrolmentRequestModel requestModel = new EnrolmentRequestModel("ade", "CSC207");
        EnrolmentResponseModel responseModel = new EnrolmentResponseModel("CSC207", questions);

        EnrolmentCourseDataAccess courseGateway = new CourseDbGateway();
        EnrolmentDataAccess sessionGateway = new SessionDbGateway();
        CheckPrerequisitesInteractor completedPrerequisites = new CheckPrerequisitesInteractor(sessionGateway);
        EnrolmentOutputBoundary presenter = new EnrolmentPresenter();

        CourseEnrolmentInteractor interactor = new CourseEnrolmentInteractor(courseGateway,
                completedPrerequisites, sessionGateway, presenter);


        assertEquals(interactor.enrol(requestModel).getCourseId(), responseModel.getCourseId());
        assertEquals(interactor.enrol(requestModel).getQuestions(), responseModel.getQuestions());
    }

}