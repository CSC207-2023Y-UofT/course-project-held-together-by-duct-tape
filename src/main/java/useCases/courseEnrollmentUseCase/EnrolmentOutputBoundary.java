package useCases.courseEnrollmentUseCase;

/**
 * The interface which separates the course enrollment interactor from the implementation of the presenter class,
 * so that the interactor does not depend on the presenter.
 */
public interface EnrolmentOutputBoundary {

    /**
     * Prepares a success view signaling successful enrollment.
     * @param course data structure containing the courseId and the questions for the course in which the student
     * has enrolled.
     * @return message indicating successful enrollment.
     */
    String prepareSuccessView(EnrolmentResponseModel course);

    /**
     * Throw error if student attempts to enroll in a course for which they have not completed the prerequisite.
     * @param failMessage message informing the student the reason for unsuccessful enrollment.
     * @return message signaling unsuccessful enrollment.
     */
    String prepareFailView(String failMessage);
}
