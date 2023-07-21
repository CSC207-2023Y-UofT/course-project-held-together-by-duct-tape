package frameworksdrivers;

import java.util.Map;
import java.util.HashMap;

import usecases.LoginStudentUseCase.LoginStudentDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;

/**
 * MOCK GATEWAY: Currently a mock gateway such that the interactor is able to perform
 * its function. Once the databases are chosen, the gateway will be modified.
 */
public class StudentDbGateway implements LoginStudentDataAccess {
    /**
     * Method returns a boolean whether a username exists in the student database.
     *
     * @param username that will be checked.
     * @return boolean that indicates if the username exists.
     */
    @Override
    public boolean usernameExists(String username) {
        return true;
    }

    /**
     * Method that adds the student courses to the request model.
     *
     * @param dbRequestModel request model that is updated with the students courses.
     */
    public void getUser(LoginStudentDbRequestModel dbRequestModel) {
        Map<String, Integer> courses = new HashMap<String, Integer>();
        courses.put("csc148", 90);
        dbRequestModel.setCourses(courses);
    }
}
