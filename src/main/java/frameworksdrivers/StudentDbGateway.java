package frameworksdrivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Map;
import java.util.HashMap;

import usecases.LoginStudentUseCase.LoginStudentDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;
import usecases.CreateStudentUsecase.CreateStudentDsModel;
import usecases.CreateStudentUsecase.CreateStudentDataAccess;

/**
 * MOCK GATEWAY: Currently a mock gateway such that the interactor is able to perform
 * its function. Once the databases are chosen, the gateway will be modified.
 */
public class StudentDbGateway extends DbConnection implements LoginStudentDataAccess, CreateStudentDataAccess {
    /**
     * Method returns a boolean whether a username exists in the student database.
     *
     * @param username that will be checked.
     * @return boolean that indicates if the username exists.
     */
    @Override
    public boolean usernameExists(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE StudentID = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error with database!");
        }
        return false;
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

    @Override
    /** Method returns whether the username is unique meaning that it's not already present in the database
     * @param username is the username that is checked for whether it is unique*/
    public boolean isUnique(String username) {
        return true;
    }
    /** Method saves the user info stored in "student" to the database
     *@param student this a model that stores what will be saved onto the database*/
    @Override
    public void save(CreateStudentDsModel student) { System.out.println("It saved!");

    }
}
