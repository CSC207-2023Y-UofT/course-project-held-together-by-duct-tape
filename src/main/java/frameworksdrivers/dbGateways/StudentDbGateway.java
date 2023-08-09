package frameworksdrivers.dbGateways;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Map;
import java.util.HashMap;

import frameworksdrivers.DbConnection;
import usecases.CourseEvaluatorUseCase.*;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;
import usecases.CreateStudentUsecase.CreateStudentDsModel;
import usecases.LoginStudentUseCase.LoginStudentRequestModel;

/**
 * Gateway that accesses and interacts with the Student Database. It has a reference to the connection obtained from
 * DbConnection. Implements the various interfaces so that interactors are able to access information from the database.
 */
public class StudentDbGateway implements StudentGateway {
    private final Connection connection;
    private final String DATABASE_NAME = "students";

    public StudentDbGateway(DbConnection dbConnection) {
        this.connection = dbConnection.connect();
    }

    /**
     * Method returns a boolean whether a username exists in the student database.
     *
     * @param username that will be checked.
     * @return boolean that indicates if the username exists.
     */
    @Override
    public boolean usernameExists(String username) {
        try {
            String SQL = "SELECT * FROM " + DATABASE_NAME + " WHERE StudentID = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error with database!");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method that retrieves the student from the student database and adds the courses to the request model.
     *
     * @param dbRequestModel request model that is updated with the students courses.
     */
    @Override
    public void getUser(LoginStudentDbRequestModel dbRequestModel) {
        try {
            String SQL = "SELECT * FROM students WHERE StudentID = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, dbRequestModel.getUsername());
            ResultSet resultSet = statement.executeQuery();

            Map<String, Float> courses = new HashMap<String, Float>();

            resultSet.next();
            dbRequestModel.setPassword(resultSet.getString(2));
            do {
                // CourseID, CourseGrade
                courses.put(resultSet.getString(3), resultSet.getFloat(4));
            } while (resultSet.next());

            dbRequestModel.setCourses(courses);
        } catch (SQLException e) {
            System.out.println("Error with database!");
            e.printStackTrace();
        }
    }

    /**
     * Returns a boolean whether the password in the database matches the password that is inputted by the user.
     *
     * @param requestModel with the username and the password to check.
     * @return true if passwords match, false otherwise.
     */
    @Override
    public boolean checkPassword(LoginStudentRequestModel requestModel) {
        try {
            String SQL = "SELECT * FROM students WHERE StudentID = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, requestModel.getUsername());
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            return resultSet.getString(2).equals(requestModel.getPassword());
        } catch (SQLException e) {
            System.out.println("Error with database!");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method saves a user when they first open a program, and they have no courses created
     *
     * @param student this is the request model containing the student password and username
     */
    @Override
    public void saveUser(CreateStudentDsModel student){
        try {
            String SQL = "INSERT INTO " + DATABASE_NAME +
                " (StudentID, Password, CourseID, CourseGrade) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, student.getUsername());
            statement.setString(2, student.getPassword());
            statement.setString(3, "DEFAULT");
            statement.setFloat(4, 0.0f);
            statement.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Error with database!");
            e.printStackTrace();
        }
    }


    /**
     * Saves the GPA of a student with a username and courseID. The courseID specifies what course the grade is from,
     * the username specifies what student got this grade.
     *
     * @param requestModel with the StudentID, CourseID, and grade.
     */
    @Override
    public void saveGPA(EvaluatorDbRequestModel requestModel) {
        try {
            String SQL = "INSERT INTO " + DATABASE_NAME + " (StudentID, Password, CourseID, CourseGrade) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, requestModel.getStudentID());
            statement.setString(2, requestModel.getPassword());
            statement.setString(3, requestModel.getCourseID());
            statement.setFloat(4, requestModel.getGrade());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error with database!");
            e.printStackTrace();
        }
    }
}
