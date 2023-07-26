package courseenrolmentusecase;

public class CourseEnrolmentInteractor implements EnrolmentInputBoundary {
    private CheckPrerequisitesInteractor completedPrerequisite;
    private EnrolmentDataAccess sessionDbGateway;
    private EnrolmentCourseDataAccess courseDbGateway;
    private EnrolmentOutputBoundary enrolmentPresenter;

    //private RunCourseInteractor runCourse;


    public CourseEnrolmentInteractor(EnrolmentCourseDataAccess courseDbGateway, CheckPrerequisitesInteractor
            completedPrerequisite, EnrolmentDataAccess sessionDbGateway, EnrolmentOutputBoundary enrolmentPresenter) {
        this.courseDbGateway = courseDbGateway;
        this.completedPrerequisite = completedPrerequisite;
        this.sessionDbGateway = sessionDbGateway;
        this.enrolmentPresenter = enrolmentPresenter;
    }

    /**
     * calls CourseDbGateway to load course from Course Database
     * @return the course packaged in a response model.
     */
    public EnrolmentDbResponseModel callToRetrieveCourse(EnrolmentRequestModel requestModel) {
        EnrolmentDbRequestModel dbRequestModel = new EnrolmentDbRequestModel(requestModel.getCourseId());
        return courseDbGateway.retrieveCourse(dbRequestModel.getCourseId());
    }

    /**
     * if enrolment was successful (i.e., if course Id exists, and student has completed all prerequisites): enrol
     * student in course (call to run course and save student and course Ids in Session Database).
     * Prepares fail message to be presented on the screen, if courseId doesn't exist, or if student doesn't have
     * the prerequisites.
     * @param requestModel stores the courseId, and studentId
     * @return the requested course or a fail message
     */
    public EnrolmentResponseModel enrol(EnrolmentRequestModel requestModel) {
        if (!courseDbGateway.existsByCourseId(requestModel.getCourseId())) {
            return enrolmentPresenter.prepareFailView("Course does not exist in Database!");
        }
        EnrolmentDbResponseModel dbResponseModel = callToRetrieveCourse(requestModel);
        if (!completedPrerequisite.checkPrerequisite(requestModel.getStudentId(), dbResponseModel)) {
            return enrolmentPresenter.prepareFailView("You have not completed the prerequisites " +
                        "for the course");
        }
        sessionDbGateway.saveCourse(requestModel.getStudentId(), requestModel.getCourseId()); //saves course with
        // student in Session database
        //beginCourse.runCourse(); //calls to run course
        EnrolmentResponseModel enrolmentResponseModel = new EnrolmentResponseModel(dbResponseModel.getCourseId(),
                        dbResponseModel.getQuestions());
        return enrolmentPresenter.prepareSuccessView(enrolmentResponseModel); //displays questions on screen
    }

}
