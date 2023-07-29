package interfaceadapters.CourseEnrollmentInterfaceAdapters;

import usecases.CourseEnrollmentUseCase.EnrolmentInputBoundary;
import usecases.CourseEnrollmentUseCase.EnrolmentRequestModel;

public class EnrolmentController {
    private final EnrolmentInputBoundary enrolmentInteractor;

    public EnrolmentController(EnrolmentInputBoundary enrolmentInteractor) {
        this.enrolmentInteractor = enrolmentInteractor;
    }

    /**
     * Creates the request model containing the input course ID and student ID; passes it to the interactor to 
     * enrol student in course.
     *
     * @param courseId the id of the course in which the student enrolls.
     * @return responseModel containing the course ID and the course's questions.
     */
    public String enrol(String courseId) {
        EnrolmentRequestModel requestModel = new EnrolmentRequestModel(courseId);
        return enrolmentInteractor.enrol(requestModel);
    }
}
