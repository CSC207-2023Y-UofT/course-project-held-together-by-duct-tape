package csc207.courseenrolmentusecase;

import csc207.courseenrolmentinterfaceadapters.EnrolmentPresenter;
import csc207.courseenrolmentusecase.*;
import csc207.entities.Question;
import csc207.frameworksdrivers.CourseDbGateway;
import csc207.frameworksdrivers.SessionDbGateway;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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