package csc207.courseenrolmentusecase;

public interface EnrolmentOutputBoundary {
    EnrolmentResponseModel prepareSuccessView(EnrolmentResponseModel course);
    EnrolmentResponseModel prepareFailView(String failMessage);
}
