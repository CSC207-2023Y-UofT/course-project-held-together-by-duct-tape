package useCases.courseEnrollmentUseCase;

/**
 * Class responsible for checking whether the student has completed the course and grade prerequisites for a particular
 * course. It has references to the session gateway.
 */
public class CheckPrerequisitesInteractor {
    private final EnrolmentSessionDataAccess sessionDbGateway;

    /**
     * Initializes the CheckPrerequisitesInteractor.
     * @param sessionDbGateway the session gateway for accessing the session database
     */
    public CheckPrerequisitesInteractor(EnrolmentSessionDataAccess sessionDbGateway) {
        this.sessionDbGateway = sessionDbGateway;
    }

    /**
     * Check whether student has completed the prerequisite for the course in which they enrol.
     *
     * @param requestModel the course in which the student attempts to enrol.
     * @return true iff student has the prerequisite for the course
     */
    public boolean checkPrerequisite(EnrolmentDbRequestModel requestModel) {
        // Empty prerequisite returns true
        if (requestModel.getPrerequisiteID().equals("")) {
            return true;
        }

        return sessionDbGateway.hasCompletedCourse(requestModel);
    }
}
