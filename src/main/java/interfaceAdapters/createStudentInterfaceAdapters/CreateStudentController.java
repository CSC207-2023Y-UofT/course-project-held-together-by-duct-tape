package interfaceAdapters.createStudentInterfaceAdapters;

import useCases.createStudentUsecase.CreateStudentInputBoundary;
import useCases.createStudentUsecase.CreateStudentRequestModel;
/**This is the controller for the createStudent controller which uses the input boundary to run the Create student
 * usecase*/
public class CreateStudentController {
    private final CreateStudentInputBoundary interactor;

    public CreateStudentController(CreateStudentInputBoundary interactor){
        this.interactor = interactor;
    }
    /**This method runs the use case and returns a success or fail message
     * @return String the success or fail message returned */
    public String create(String username, String password, String repeat){
        CreateStudentRequestModel requestModel = new CreateStudentRequestModel(username, password, repeat);
        return interactor.createStudent(requestModel);
    }
}
