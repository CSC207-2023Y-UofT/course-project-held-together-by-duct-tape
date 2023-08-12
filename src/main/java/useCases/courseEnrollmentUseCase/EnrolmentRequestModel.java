package useCases.courseEnrollmentUseCase;

/**
 * Data structure containing the course ID for the course in which the student attempts to enroll.
 * An EnrolmentRequestModel object is created by the controller in order for the interactor to enrol the student in
 * the course corresponding to this ID.
 */
public class EnrolmentRequestModel {
    private final String courseId;

    /**
     * Initializes the request model.
     * @param courseId the course ID for the course in which the student enrolls.
     */
    public EnrolmentRequestModel(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }
}
