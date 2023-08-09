package usecases.createStudentUsecase;

/**
 * This interface is implemented by a presenter to seperate concerns and adhere to clean architecture.
 */
public interface CreateStudentOutputBoundary {
    /**
     * This method formats and returns a success message based on the response model passed
     *
     * @param responseModel is a response model that contains what is needed to format the success message.
     * @return String with the success message.
     */
    String getSuccessMessage(CreateStudentResponseModel responseModel);

    /**
     * This method formats and returns the message that is shown upon failure of creating a new student user
     *
     * @return String with the fail message.
     */
    String getFailMessage();
}


