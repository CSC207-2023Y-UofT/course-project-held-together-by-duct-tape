package usecases.CreateStudentUsecase;

public interface CreateStudentOutputBoundary {
    String getSuccessMessage(CreateStudentResponseModel responseModel);
    String getFailMessage();
}
