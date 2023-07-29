package frameworksdrivers.Gateways;

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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + DATABASE_NAME + " WHERE StudentID = ?");
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
    @Override
    public void getUser(LoginStudentDbRequestModel dbRequestModel) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE StudentID = ?");
            statement.setString(1, dbRequestModel.getUsername());
            ResultSet resultSet = statement.executeQuery();

            Map<String, Integer> courses = new HashMap<String, Integer>();
            while (resultSet.next()) {
                // CourseID, CourseGrade
                courses.put(resultSet.getString(3), resultSet.getInt(4));
            }

            dbRequestModel.setCourses(courses);
        } catch (SQLException e) {
            System.out.println("Error with database!");
        }
    }

    @Override
    public boolean checkPassword(LoginStudentRequestModel requestModel) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE StudentID = ?");
            statement.setString(1, requestModel.getUsername());
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            return resultSet.getString(2).equals(requestModel.getPassword());
            // return resultSet.getString(2).equals(requestModel.getPassword());
        } catch (SQLException e) {
            System.out.println("Error with database!");
        }
        return false;
    }

    /**
     * Method saves the user info stored in "student" to the database.
     *
     * @param student model that stores what will be saved onto the database.
     */
    @Override
    public void saveUser(CreateStudentDsModel student) {
        try{
            Map<String, Integer> courses = student.getCourseList();

            for (Map.Entry<String, Integer> course : courses.entrySet()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO " + DATABASE_NAME + " (StudentID, Password, CourseID, CourseGrade) VALUES (?, ?, ?, ?)");
                statement.setString(1, student.getUsername());
                statement.setString(2, student.getPassword());
                statement.setString(3, course.getKey());
                statement.setString(4, "0");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with database!");
        }
    }

    @Override
    public int saveGPA(EvaluatorDbRequestModel requestModel) {
        return 0;
    }
}
