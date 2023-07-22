package InterfaceAdaptors.CreateStudentInterfaceAdaptors;
import CreateStudentUsecase.CreateStudentOutputBoundary;
import CreateStudentUsecase.CreateStudentResponseModel;

public class CreateStudentPresenter implements CreateStudentOutputBoundary{

    @Override
    public String getSuccessMessage(CreateStudentResponseModel responseModel) {
        return "You have successfully created a New student! Welcome" + " " + responseModel.getUsername();}

    @Override
    public String getFailMessage() {
        return "Sorry it appears that either the Username already exists or you provided two different usernames";}}
