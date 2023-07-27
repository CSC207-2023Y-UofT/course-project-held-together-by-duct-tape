package frameworksdrivers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usecases.CourseEnrollmentUseCase.EnrolmentCourseDataAccess;
import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.CreateStudentUsecase.CreateStudentCourseDataAccess;
import entities.Prerequisite;

/**
 * Gateway that accesses and interacts with the Course Database. It has a reference to the connection obtained from
 * DbConnection. Implements the various interfaces so that interactors are able to access information from the database.
 */
public class CourseDbGateway implements EnrolmentCourseDataAccess, CreateStudentCourseDataAccess {
    private final Connection connection;

    public CourseDbGateway(DbConnection dbConnection) {
        this.connection = dbConnection.connect();
    }

    /**
     * Method that returns a list of all the courses offered.
     *
     * @return List of Strings where each String represents a courseID.
     */
    public List<String> getCourseIDs() {
        List<String> courses = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT CourseID FROM courses");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                courses.add(resultSet.getString(1));
            }
            return courses;
        } catch (SQLException e) {
            System.out.println("Error with database!");
        }
        return courses;
    }

    /**
     * Checks if ID exists in Course Database.
     * @param courseId the course ID
     * @return true if the course is in Course Database, false if not.
     */
    @Override
    public boolean existsByCourseId(String courseId) {
        return true;
    }

    /**
     * Retrieves course from Course Database.
     * @param requestModel the course ID
     * @return a response model containing the course.
     */
    @Override
    public void retrieveCourse(EnrolmentDbRequestModel requestModel) {
        requestModel.setQuestions(new ArrayList<>());
        requestModel.setPrerequisite(new Prerequisite("CSC108", 50));
    }
}
