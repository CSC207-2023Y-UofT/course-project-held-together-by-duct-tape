package usecases.CourseEnrollmentUseCase;

public interface EnrolmentOutputBoundary {
    String prepareSuccessView(EnrolmentResponseModel course);
    String prepareFailView(String failMessage);
}
