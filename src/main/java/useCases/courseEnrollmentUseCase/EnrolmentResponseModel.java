package useCases.courseEnrollmentUseCase;

/**
 * Data structure which packages the course ID and the questions to be displayed on the screen.
 */
public class EnrolmentResponseModel {
    private final String courseId;

    /**
     * Initializes the response model.
     * @param courseId the name of the course in which the student has successfully enrolled.
     */
    public EnrolmentResponseModel(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }
}
