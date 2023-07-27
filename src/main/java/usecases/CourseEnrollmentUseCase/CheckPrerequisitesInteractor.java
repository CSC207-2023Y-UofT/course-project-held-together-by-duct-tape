package usecases.CourseEnrollmentUseCase;


public class CheckPrerequisitesInteractor {
    private final EnrolmentDataAccess sessionDbGateway;

    public CheckPrerequisitesInteractor(EnrolmentDataAccess sessionDbGateway) {
        this.sessionDbGateway = sessionDbGateway;
    }

    /**
     * Check whether student has completed the prerequisite for the course in which they enrol.
     *
     * @param course the course in which the student attempts to enrol.
     * @return true iff student has the prerequisite for the course
     */
    public boolean checkPrerequisite(EnrolmentDbResponseModel course) {
        if (course.getPrerequisite().isEmpty()) {
            return true;
        }

        boolean completed = sessionDbGateway.hasCompletedCourse(course.getPrerequisite().getCourse());
        int grade = sessionDbGateway.getCourseGPA(course.getPrerequisite().getCourse());
        return completed && grade >= course.getPrerequisite().getGpa();
    }
}
