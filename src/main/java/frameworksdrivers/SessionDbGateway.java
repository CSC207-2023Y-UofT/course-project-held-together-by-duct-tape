package frameworksdrivers;

import usecases.LoginStudentUseCase.LoginSessionDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;

/**
 * MOCK GATEWAY: Currently a mock gateway such that the interactor is able to perform
 * its function. Once the databases are chosen, the gateway will be modified.
 */
public class SessionDbGateway implements LoginSessionDataAccess {
    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    public void saveUser(LoginStudentDbRequestModel requestModel) {}
}
