package frameworksdrivers.Gateways;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import frameworksdrivers.DbConnection;
import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.CourseEvaluatorUseCase.EvaluatorDbResponseModel;
import usecases.CourseEvaluatorUseCase.EvaluatorRequestModel;

/**
 * Gateway that accesses and interacts with the Course Database. It has a reference to the connection obtained from
 * DbConnection. Implements the various interfaces so that interactors are able to access information from the database.
 */
public class CourseDbGateway implements CourseGateway {
    private final Connection connection;
    private final String DATABASE_NAME = "courses";

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
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT CourseID FROM " + DATABASE_NAME);
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
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + DATABASE_NAME + " WHERE CourseID = ?");
            statement.setString(1, courseId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
        return false;
    }

    /**
     * Retrieves course from Course Database.
     * @param requestModel the course ID
     */
    @Override
    public void retrieveCourse(EnrolmentDbRequestModel requestModel) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + DATABASE_NAME + " WHERE CourseID = ?");
            statement.setString(1, requestModel.getCourseID());
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            requestModel.setPrerequisiteID(resultSet.getString(2));
            requestModel.setPrerequisiteGrade(resultSet.getInt(3));

            List<String> questions = new ArrayList<String>();
            List<Integer> points = new ArrayList<>();
            do {
                questions.add(resultSet.getString(4));
                points.add(resultSet.getInt( 6));
            } while (resultSet.next());

            requestModel.setQuestions(questions);
            requestModel.setPoints(points);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error with the database!");
        }
    }

    @Override
    public void findCourse(EvaluatorDbResponseModel requestModel) {
        try {
            List<String> questions = new ArrayList<>();
            List<String> answers = new ArrayList<>();
            List<Integer> points = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + DATABASE_NAME + " WHERE CourseID = ?");
            statement.setString(1, requestModel.getCourseId());
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            do {
                questions.add(resultSet.getString(4));
                answers.add(resultSet.getString(5));
                points.add(resultSet.getInt(6));
            } while (resultSet.next());

            requestModel.setQuestions(questions);
            requestModel.setAnswers(answers);
            requestModel.setPoints(points);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error with the database!");
        }
    }
}