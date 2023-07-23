package CourseEnrolmentUseCase;

public interface EnrolmentOutputBoundary {
    EnrolmentResponseModel prepareSuccessView(EnrolmentResponseModel course);
    EnrolmentResponseModel prepareFailView(String failMessage);
}
