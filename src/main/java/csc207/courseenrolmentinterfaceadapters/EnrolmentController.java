package csc207.courseenrolmentinterfaceadapters;

import csc207.courseenrolmentusecase.EnrolmentInputBoundary;
import csc207.courseenrolmentusecase.EnrolmentRequestModel;
import csc207.courseenrolmentusecase.EnrolmentResponseModel;

public class EnrolmentController {
    private final EnrolmentInputBoundary enrolmentInteractor;
    public EnrolmentController(EnrolmentInputBoundary enrolmentInteractor) {
        this.enrolmentInteractor = enrolmentInteractor;
    }

    /**
     * Creates the request model containing the input course ID and student ID; passes it to the interactor to 
     * enrol student in course. 
     * @param studentId the student's id
     * @param courseId the id of the course in which the student enrolls.
     * @return responseModel containing the course ID and the course's questions.
     */
    public EnrolmentResponseModel enrol(String studentId, String courseId) {
        EnrolmentRequestModel requestModel = new EnrolmentRequestModel(studentId, courseId);
        return enrolmentInteractor.enrol(requestModel);
    }
}
