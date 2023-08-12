package useCases.courseEnrollmentUseCase;

/**
 * The interface which separates the controller from the implementation of the course enrollment interactor.
 */
public interface EnrolmentInputBoundary {
    /**
     * if enrolment was successful (i.e., if student has completed all prerequisites): enrol
     * student in course (call to run course and save student and course Ids in Session Database).
     * Prepares fail message to be presented on the screen, if student doesn't have the prerequisites.
     * @param requestModel stores the courseId, and studentId
     * @return the requested course or a fail message
     */
    String enrol(EnrolmentRequestModel requestModel);
}
