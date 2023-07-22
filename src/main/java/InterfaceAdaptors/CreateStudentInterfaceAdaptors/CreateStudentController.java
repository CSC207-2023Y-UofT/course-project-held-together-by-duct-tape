package InterfaceAdaptors.CreateStudentInterfaceAdaptors;
import CreateStudentUsecase.CreateStudentInputBoundary;
import CreateStudentUsecase.CreateStudentRequestModel;
public class CreateStudentController {
    private CreateStudentInputBoundary interactor;
    public CreateStudentController(CreateStudentInputBoundary interactor){
        this.interactor = interactor;}

    public String create(String username, String repeat){
        CreateStudentRequestModel requestModel = new CreateStudentRequestModel(username, repeat);
        return interactor.createStudent(requestModel);}}
