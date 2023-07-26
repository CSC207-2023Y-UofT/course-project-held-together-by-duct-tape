package courseenrolmentusecase;


public class CheckPrerequisitesInteractor {
    private EnrolmentDataAccess sessionDbGateway;

    public CheckPrerequisitesInteractor(EnrolmentDataAccess sessionDbGateway) {
        this.sessionDbGateway = sessionDbGateway;
    }

    /**
     * Check whether student has completed the prerequisite for the course in which they enrol.
     * @param studentId the student's id
     * @param course the course in which the student attempts to enrol.
     * @return true iff student has the prerequisite for the course
     */
    public boolean checkPrerequisite(String studentId, EnrolmentDbResponseModel course) {
        boolean completed = sessionDbGateway.hasCompletedCourse(studentId, course.getPrerequisite().getCourse());
        int grade = sessionDbGateway.getCourseGPA(studentId, course.getPrerequisite().getCourse());
        return completed && grade >= course.getPrerequisite().getGpa();
    }
}
// add a data structure storing the prerequisite for the course!!!