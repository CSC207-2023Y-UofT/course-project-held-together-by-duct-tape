package usecases.CourseEnrollmentUseCase;

public class CourseEnrolmentInteractor implements EnrolmentInputBoundary {
    private final CheckPrerequisitesInteractor completedPrerequisite;
    private final EnrolmentSessionDataAccess sessionDbGateway;
    private final EnrolmentCourseDataAccess courseDbGateway;
    private final EnrolmentOutputBoundary enrolmentPresenter;

    public CourseEnrolmentInteractor(EnrolmentCourseDataAccess courseDbGateway, CheckPrerequisitesInteractor
            completedPrerequisite, EnrolmentSessionDataAccess sessionDbGateway, EnrolmentOutputBoundary enrolmentPresenter) {
        this.courseDbGateway = courseDbGateway;
        this.completedPrerequisite = completedPrerequisite;
        this.sessionDbGateway = sessionDbGateway;
        this.enrolmentPresenter = enrolmentPresenter;
    }

    /**
     * calls CourseDbGateway to load course from Course Database
     */
    public void callToRetrieveCourse(EnrolmentDbRequestModel dbRequestModel) {
        courseDbGateway.retrieveCourse(dbRequestModel);
    }

    /**
     * if enrolment was successful (i.e., if course ID exists, and student has completed all prerequisites): enrol
     * student in course (call to run course and save student and course Ids in Session Database).
     * Prepares fail message to be presented on the screen, if courseId doesn't exist, or if student doesn't have
     * the prerequisites.
     * @param requestModel stores the courseId, and studentId
     * @return the requested course or a fail message
     */
    public String enrol(EnrolmentRequestModel requestModel) {
        if (!courseDbGateway.existsByCourseId(requestModel.getCourseId())) {
            return enrolmentPresenter.prepareFailView("Course does not exist in Database!");
        }

        EnrolmentDbRequestModel dbRequestModel = new EnrolmentDbRequestModel(requestModel.getCourseId());
        // we might no longer need the method below since it is only one function call
        callToRetrieveCourse(dbRequestModel);

        if (!completedPrerequisite.checkPrerequisite(dbRequestModel)) {
            return enrolmentPresenter.prepareFailView("You have not completed the prerequisites " +
                        "for the course.\nPrerequisite: " + dbRequestModel.getPrerequisiteID() + " Grade: " + dbRequestModel.getPrerequisiteGrade());
        }

        sessionDbGateway.saveCourse(dbRequestModel);

        EnrolmentResponseModel enrolmentResponseModel = new EnrolmentResponseModel(requestModel.getCourseId());
        return enrolmentPresenter.prepareSuccessView(enrolmentResponseModel);
    }

}
