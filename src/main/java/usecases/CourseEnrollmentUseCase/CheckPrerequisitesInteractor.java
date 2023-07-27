package usecases.CourseEnrollmentUseCase;


public class CheckPrerequisitesInteractor {
    private final EnrolmentSessionDataAccess sessionDbGateway;

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
        if (requestModel.getPrerequisite().isEmpty()) {
            return true;
        }

        boolean completed = sessionDbGateway.hasCompletedCourse(requestModel);
        int grade = sessionDbGateway.getPrerequisiteCourseGPA(requestModel);
        return completed && grade >= requestModel.getPrerequisite().getGpa();
    }
}
