package interfaceadapters.CourseEnrollmentInterfaceAdapters;

import frameworksdrivers.CourseDbGateway;
import usecases.CourseEnrollmentUseCase.EnrolmentOutputBoundary;
import usecases.CourseEnrollmentUseCase.EnrolmentResponseModel;

import java.util.List;

public class EnrolmentPresenter implements EnrolmentOutputBoundary {
    private final CourseDbGateway courseDbGateway;

    public EnrolmentPresenter(CourseDbGateway courseDbGateway) {
        this.courseDbGateway = courseDbGateway;
    }

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
        throw new RuntimeException(failMessage);
    }

    /**
     * Get a list of the course IDs offered. This method will call the course gateway to access the database to
     * retrieve the course IDs.
     *
     * @return List of Strings with the course IDs.
     */
    public List<String> getCourseIDs() {
        return courseDbGateway.getCourseIDs();
    }
}
