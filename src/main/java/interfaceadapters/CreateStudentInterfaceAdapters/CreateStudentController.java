package interfaceadapters.CreateStudentInterfaceAdapters;

import usecases.CreateStudentUsecase.CreateStudentInputBoundary;
import usecases.CreateStudentUsecase.CreateStudentRequestModel;

public class CreateStudentController {
    private final CreateStudentInputBoundary interactor;

    public CreateStudentController(CreateStudentInputBoundary interactor){
        this.interactor = interactor;
    }

    public String create(String username, String password, String repeat){
        CreateStudentRequestModel requestModel = new CreateStudentRequestModel(username, password, repeat);
        return interactor.createStudent(requestModel);
    }
}
