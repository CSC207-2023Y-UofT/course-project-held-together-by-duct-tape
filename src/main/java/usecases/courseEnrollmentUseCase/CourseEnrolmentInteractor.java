package usecases.courseEnrollmentUseCase;

/**
 * This is the course enrollment interactor which enrolls the student in the selected course. It has references
 * to the check prerequisites interactor, session gateway, course gateway, as well as the enrollment presenter.
 */
public class CourseEnrolmentInteractor implements EnrolmentInputBoundary {
    private final CheckPrerequisitesInteractor completedPrerequisite;
    private final EnrolmentSessionDataAccess sessionDbGateway;
    private final EnrolmentCourseDataAccess courseDbGateway;
    private final EnrolmentOutputBoundary enrolmentPresenter;

    /**
     * Initializes the CourseEnrolmentInteractor.
     * @param courseDbGateway retrieves the course from the database
     * @param completedPrerequisite checks if student has completed the prerequisites for the course
     * @param sessionDbGateway the class through which the session database is accessed in order to check
     *                         prerequisites completion and save the course
     * @param enrolmentPresenter displays success/fail messages
     */
    public CourseEnrolmentInteractor(EnrolmentCourseDataAccess courseDbGateway,
                                     CheckPrerequisitesInteractor completedPrerequisite,
                                     EnrolmentSessionDataAccess sessionDbGateway,
                                     EnrolmentOutputBoundary enrolmentPresenter) {
        this.courseDbGateway = courseDbGateway;
        this.completedPrerequisite = completedPrerequisite;
        this.sessionDbGateway = sessionDbGateway;
        this.enrolmentPresenter = enrolmentPresenter;
    }

    /**
     * if enrolment was successful (if course ID exists in database and student has completed all prerequisites): enrol
     * student in course (call to run course and save student and course Ids in Session Database).
     * Prepares fail message to be presented on the screen, if course ID does not exist student doesn't have the
     * prerequisites.
     * @param requestModel stores the courseId, and studentId
     * @return the requested course or a fail message
     */
    public String enrol(EnrolmentRequestModel requestModel) {
        if (!courseDbGateway.existsByCourseId(requestModel.getCourseId())) {
            return enrolmentPresenter.prepareFailView("Course ID does not exist in Database!");
        }

        EnrolmentDbRequestModel dbRequestModel = new EnrolmentDbRequestModel(requestModel.getCourseId());
        courseDbGateway.retrieveCourse(dbRequestModel);

        if (!completedPrerequisite.checkPrerequisite(dbRequestModel)) {
            return enrolmentPresenter.prepareFailView("You have not completed the prerequisites " +
                        "for the course.\nPrerequisite: " + dbRequestModel.getPrerequisiteID() + " Grade: " +
                    dbRequestModel.getPrerequisiteGrade());
        }

        sessionDbGateway.saveCourse(dbRequestModel);

        EnrolmentResponseModel enrolmentResponseModel = new EnrolmentResponseModel(requestModel.getCourseId());
        return enrolmentPresenter.prepareSuccessView(enrolmentResponseModel);
    }
}