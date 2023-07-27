package interfaceadapters.CourseEnrollmentInterfaceAdapters;

import usecases.CourseEnrollmentUseCase.EnrolmentOutputBoundary;
import usecases.CourseEnrollmentUseCase.EnrolmentResponseModel;

public class EnrolmentPresenter implements EnrolmentOutputBoundary {
    /**
     * Prepares a success view signaling successful enrollment.
     * @param course data structure containing the courseId and the questions for the course in which the student
     * has enrolled.
     * @return course, with courseId and questions to be displayed on screen.
     */
    @Override
    public EnrolmentResponseModel prepareSuccessView(EnrolmentResponseModel course) {
        return course;
    }
    /**
     * Throw error if student attempts to enroll in a nonexistent course, or a course for which they have not completed
     * the prerequisite.
     * @param failMessage message informing the student the reason for unsuccessful enrollment.
     * @return exception containing the fail message.
     */
    @Override
    public EnrolmentResponseModel prepareFailView(String failMessage) {
        throw new RuntimeException(failMessage);
    }
}
