package interfaceadapters.CourseEnrollmentInterfaceAdapters;

import usecases.CourseEnrollmentUseCase.EnrolmentOutputBoundary;
import usecases.CourseEnrollmentUseCase.EnrolmentResponseModel;

public class EnrolmentPresenter implements EnrolmentOutputBoundary {
    /**
     * Prepares a success view signaling successful enrollment.
     * @param course data structure containing the courseId and the questions for the course in which the student
     * has enrolled.
     * @return message indicating successful enrollment.
     */
    @Override
    public String prepareSuccessView(EnrolmentResponseModel course) {
        return "You've successfully enrolled in course " + course.getCourseId();
    }
    /**
     * Throw error if student attempts to enroll in a nonexistent course, or a course for which they have not completed
     * the prerequisite.
     * @param failMessage message informing the student the reason for unsuccessful enrollment.
     * @return message signaling unsuccessful enrollment.
     */
    @Override
    public String prepareFailView(String failMessage) {
        return failMessage;
    }
}
