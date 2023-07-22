package usecases.CreateStudentUsecase;

public class CreateStudentInteractor implements CreateStudentInputBoundary{
    final CreateStudentDataAccess dataAccess;
    final CreateStudentOutputBoundary presenter;

    public CreateStudentInteractor(CreateStudentDataAccess dataAccess, CreateStudentOutputBoundary presenter){
        this.dataAccess = dataAccess;
        this.presenter = presenter;}

    public void createStudent(CreateStudentRequestModel request) {
        CreateStudentResponseModel response = new CreateStudentResponseModel(request.getUsername());
        boolean unique = dataAccess.isUnique(request.getUsername());
        boolean same = request.getRepeat() == request.getUsername();
        if (unique & same) {CreateStudentDsModel save = new CreateStudentDsModel(request.getUsername());
            dataAccess.save(save);;
            presenter.getSuccessMessage(response);}
        else{presenter.getFailMessage();}}}
