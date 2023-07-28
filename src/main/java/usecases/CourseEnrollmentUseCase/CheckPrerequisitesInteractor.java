package usecases.CourseEnrollmentUseCase;


import entities.Course;

public class CheckPrerequisitesInteractor {
    private final EnrolmentSessionDataAccess sessionDbGateway;

    public CheckPrerequisitesInteractor(EnrolmentSessionDataAccess sessionDbGateway) {
        this.sessionDbGateway = sessionDbGateway;
    }

    /**
     * Check whether student has completed the prerequisite for the course in which they enrol.
     *
     * @param course the course in which the student attempts to enrol.
     * @return true iff student has the prerequisite for the course
     */
    public boolean checkPrerequisite(EnrolmentDbRequestModel requestModel) {
        // Empty prerequisite returns true
        if (requestModel.getPrerequisiteID().equals("")) {
            return true;
        }

        EnrolmentDbRequestModel dbRequestModel = new EnrolmentDbRequestModel(requestModel.getCourseID());
        boolean completed = sessionDbGateway.hasCompletedCourse(dbRequestModel);
        int grade = sessionDbGateway.getPrerequisiteCourseGPA(dbRequestModel);
        return completed && grade >= requestModel.getPrerequisiteGrade();
    }
}
