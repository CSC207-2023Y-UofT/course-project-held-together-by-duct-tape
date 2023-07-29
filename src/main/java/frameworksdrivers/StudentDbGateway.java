package frameworksdrivers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import usecases.LoginStudentUseCase.LoginStudentDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;
import usecases.CreateStudentUsecase.CreateStudentDsModel;
import usecases.CreateStudentUsecase.CreateStudentDataAccess;

/**
 * Gateway that accesses and interacts with the Student Database. It has a reference to the connection obtained from
 * DbConnection. Implements the various interfaces so that interactors are able to access information from the database.
 */
public class StudentDbGateway implements LoginStudentDataAccess, CreateStudentDataAccess {
    private final Connection connection;

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
    @Override
    public void getUser(LoginStudentDbRequestModel dbRequestModel) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE StudentID = ?");
            statement.setString(1, dbRequestModel.getUsername());
            ResultSet resultSet = statement.executeQuery();

            Map<String, Integer> courses = new HashMap<String, Integer>();
            while (resultSet.next()) {
                // CourseID, CourseGrade
                courses.put(resultSet.getString(2), resultSet.getInt(3));
            }

            dbRequestModel.setCourses(courses);
        } catch (SQLException e) {
            System.out.println("Error with database!");
        }
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
        List<String> courseNames = (List<String>) courses.keySet();
        for(String course: courseNames){
            courses.get(course);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students (StudentID, Password," +
                    " CourseID, CourseGrade) Values (" +student.getUsername() +", " + student.getPassword() +", "+
                    course +", "+ courses.get(course)+")");
            statement.executeQuery();}
        } catch (SQLException e) {
            System.out.println("Error with database!");
        }
    }
}
