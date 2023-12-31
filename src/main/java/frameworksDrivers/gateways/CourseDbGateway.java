package frameworksDrivers.gateways;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import frameworksDrivers.DbConnection;
import useCases.courseEnrollmentUseCase.EnrolmentDbRequestModel;
import useCases.courseEvaluatorUseCase.EvaluatorDbResponseModel;
import useCases.createCourseUseCase.CourseDbRequestModel;

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
            String SQL = "SELECT DISTINCT CourseID FROM " + DATABASE_NAME;
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                courses.add(resultSet.getString(1));
            }
            return courses;
        } catch (SQLException e) {
            System.out.println("Error with database!");
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Retrieves course from Course Database.
     *
     * @param requestModel the course ID
     */
    @Override
    public void retrieveCourse(EnrolmentDbRequestModel requestModel) {
        try {
            String SQL = "SELECT * FROM " + DATABASE_NAME + " WHERE CourseID = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, requestModel.getCourseID());
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            requestModel.setPrerequisiteID(resultSet.getString(2));
            requestModel.setPrerequisiteGrade(resultSet.getFloat(3));

            List<String> questions = new ArrayList<String>();
            List<Integer> points = new ArrayList<>();
            do {
                questions.add(resultSet.getString(4));
                points.add(resultSet.getInt( 6));
            } while (resultSet.next());

            requestModel.setQuestions(questions);
            requestModel.setPoints(points);
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the course from the database.
     *
     * @param requestModel with the courseID to be retrieved.
     */
    @Override
    public void findCourse(EvaluatorDbResponseModel requestModel) {
        try {
            List<String> questions = new ArrayList<>();
            List<String> answers = new ArrayList<>();
            List<Integer> points = new ArrayList<>();

            String SQL = "SELECT * FROM " + DATABASE_NAME + " WHERE CourseID = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
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
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }

    /**
     * Save a newly created course into the course database.
     *
     * @param requestModel The data model representing the course to be saved.
     */
    @Override
    public void saveCourse(CourseDbRequestModel requestModel) {
        try {
            List<String> questions = requestModel.getQuestions();
            List<String> answers = requestModel.getAnswers();
            List<Integer> points = requestModel.getPoints();

            for (int j = 0; j < questions.size(); j++) {
                String SQL = "INSERT INTO " + DATABASE_NAME +
                        " (CourseID, PrerequisiteCourseID, PrerequisiteGrade, " +
                        "Question, Answer, Points) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(SQL);
                statement.setString(1, requestModel.getCourseId());
                statement.setString(2, requestModel.getPrereq());
                statement.setFloat(3, requestModel.getPrereqGrade());
                statement.setString(4, questions.get(j));
                statement.setString(5, answers.get(j));
                statement.setInt(6, points.get(j));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }

    /**
     * Checks if ID exists in Course Database.
     *
     * @param courseId the course ID
     * @return true if the course is in Course Database, false if not.
     */
    @Override
    public boolean existsByCourseId(String courseId) {
        try {
            String SQL = "SELECT * FROM " + DATABASE_NAME + " WHERE CourseID = ?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, courseId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
        return false;
    }
}
