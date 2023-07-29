package interfaceadapters.CreateStudent;
import usecases.CreateStudentUsecase.CreateStudentInputBoundary;
import usecases.CreateStudentUsecase.CreateStudentRequestModel;
public class CreateStudentController {
    private CreateStudentInputBoundary interactor;
    public CreateStudentController(CreateStudentInputBoundary interactor){
        this.interactor = interactor;}

    public String create(String username, String repeat, String password){
        CreateStudentRequestModel requestModel = new CreateStudentRequestModel(username, repeat, password);
        return interactor.createStudent(requestModel);}}
