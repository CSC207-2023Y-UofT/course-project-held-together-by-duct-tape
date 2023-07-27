package usecases.CreateStudentUsecase;

import entities.Student;
import entities.StudentFactory;

/** This is a use case interacter that runs the create student use case, and it has a reference to a Student database
 * gateway and a presenter for the create user screen and a presenter */
public class CreateStudentInteractor implements CreateStudentInputBoundary{
    final CreateStudentDataAccess dataAccess;
    final CreateStudentOutputBoundary presenter;
    final CreateStudentCourseDataAccess courseGateway;
    final StudentFactory factory;

    public CreateStudentInteractor(CreateStudentDataAccess dataAccess, CreateStudentOutputBoundary presenter,
                                   CreateStudentCourseDataAccess courseGateway, StudentFactory factory){
        this.dataAccess = dataAccess;
        this.presenter = presenter;
        this.courseGateway = courseGateway;
        this.factory = factory;}
    /** This is a use case in which a user can create a new Student profile
     * a "request" is passed through and contains the necessary information to create the user
     * if the user is successfully saved to the database a success message is shown otherwise a fail message
     * will be shown.
     * @param request contains the necessary information that is needed to create a profile in the Student Database*/
    public String createStudent(CreateStudentRequestModel request) {
        CreateStudentResponseModel response = new CreateStudentResponseModel(request.getUsername());
        boolean unique = !dataAccess.usernameExists(request.getUsername()) & !request.getUsername().equals("");
        boolean same = isSame(request);
        if (unique & same) {
            Student student = factory.create(request.getUsername(), courseGateway.getCourseIDs());
            CreateStudentDsModel save = new CreateStudentDsModel(student, request.getPassword());
            dataAccess.saveUser(save);
            return presenter.getSuccessMessage(response);}
        else{return presenter.getFailMessage();}}

    /**This method checks if the two passwords entered are unique and are not empty and returns true if and only if
     * that's the case
     * @param request this is the request model that is storing the passwords
     * @return boolean that reflects if they are the same and aren't empty*/
    public boolean isSame(CreateStudentRequestModel request){return request.getRepeat().equals(request.getPassword()) &
            !request.getRepeat().equals("") & !request.getPassword().equals("");}

}




