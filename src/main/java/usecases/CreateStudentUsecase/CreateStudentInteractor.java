package usecases.CreateStudentUsecase;
/** This is a use case interacter that runs the create student use case, and it has a reference to a Student database
 * gateway and a presenter for the create user screen and a presenter */
public class CreateStudentInteractor implements CreateStudentInputBoundary{
    final CreateStudentDataAccess dataAccess;
    final CreateStudentOutputBoundary presenter;

    public CreateStudentInteractor(CreateStudentDataAccess dataAccess, CreateStudentOutputBoundary presenter){
        this.dataAccess = dataAccess;
        this.presenter = presenter;}
    /** This is a use case in which a user can create a new Student profile
     * a "request" is passed through and contains the necessary information to create the user
     * if the user is successfully saved to the database a success message is shown otherwise a fail message
     * will be shown.
     * @param request contains the necessary information that is needed to create a profile in the Student Database*/
    public String createStudent(CreateStudentRequestModel request) {
        CreateStudentResponseModel response = new CreateStudentResponseModel(request.getUsername());
        boolean unique = dataAccess.isUnique(request.getUsername()) && request.getUsername() != null;
        boolean same = request.getRepeat().equals(request.getUsername());
        if (unique & same) {CreateStudentDsModel save = new CreateStudentDsModel(request.getUsername());
            dataAccess.save(save);;
            return presenter.getSuccessMessage(response);}
        else{return presenter.getFailMessage();}}}
