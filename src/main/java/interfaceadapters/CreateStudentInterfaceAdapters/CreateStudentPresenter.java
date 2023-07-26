package interfaceadapters.CreateStudentInterfaceAdapters;
import usecases.CreateStudentUsecase.CreateStudentOutputBoundary;
import usecases.CreateStudentUsecase.CreateStudentResponseModel;

/**This class implements the CreateStudent output boundary and formats the success and fail messages*/
public class CreateStudentPresenter implements CreateStudentOutputBoundary{

    /**This method formats and returns a success message based on the response model passed
     * @param responseModel is a response model that contains what is needed to format the success message */
    @Override
    public String getSuccessMessage(CreateStudentResponseModel responseModel) {
        return "You have successfully created a New student! Welcome" + " " + responseModel.getUsername();}

    /**This method formats and returns the message that is shown upon failure of creating a new student user*/
    @Override
    public String getFailMessage() {
        return "Sorry it appears that either the Username already exists or you provided two different usernames";}}