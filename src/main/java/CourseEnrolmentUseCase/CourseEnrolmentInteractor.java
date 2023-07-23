package UseCases;

public class CourseEnrolmentInteractor {
    private CheckPrerequisitesInteractor completedPrerequisite;
    private EnrollmentDataAccess sessionDbGateway;
    private EnrolmentCourseDataAccess courseDbGateway;
    private EnrolmentOutputBoundary enrolmentPresenter;
    private EnrolmentRequestModel enrolmentRequestModel;
    private EnrolmentResponseModel enrolmentResponseModel;
    private EnrolmentDbResponseModel course;


    /**
     * calls to load course from Course Database
     */
    public void retrieveCourse() {

    }

    /**
     * calls to run course
     */

    public EnrolmentResponseModel enrol(EnrolmentRequestModel requestModel) {
        if (!courseDbGateway.existsByCourseId(requestModel.getCourseId())) {
            return enrolmentPresenter.prepareFailView("Course does not exist in Database!");
        } else if (!completedPrerequisite.checkPrerequisite(course)) {
            return enrolmentPresenter.prepareFailView("You have not completed the prerequisites " +
                    "for the course");
        }
        sessionDbGateway.saveCourse(enrolmentRequestModel.getStudentId(), enrolmentRequestModel.getCourseId());
        return enrolmentPresenter.prepareSuccessView(enrolmentResponseModel);
    }

}
