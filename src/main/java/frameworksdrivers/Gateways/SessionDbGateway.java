package frameworksdrivers.Gateways;

import frameworksdrivers.DbConnection;
import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.CourseEvaluatorUseCase.EvaluatorDbResponseModel;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;
import usecases.RunCourseUseCase.RunCourseDbRequestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.Map;

/**
 * Gateway that accesses and interacts with the Session Database. It has a reference to the connection obtained from
 * DbConnection. Implements the various interfaces so that interactors are able to access information from the database.
 */
public class SessionDbGateway implements SessionGateway {
    private final Connection connection;
    private final String DATABASE_NAME_STUDENT = "sessionStudent";
    private final String DATABASE_NAME_COURSE = "sessionCourse";

    public SessionDbGateway(DbConnection dbConnection) {
        this.connection = dbConnection.connect();
    }

    /**
     * Checks if student has completed the course in Session Database.
     *
     * @param requestModel the course ID
     * @return true if student has completed the course, false if not.
     */
    @Override
    public boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT CourseID, CourseGrade FROM " + DATABASE_NAME_STUDENT + " WHERE CourseID=?");
            statement.setString(1, requestModel.getPrerequisiteID());
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return false;
            }

            return resultSet.getInt(2) == requestModel.getPrerequisiteGrade();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
        return false;
    }

    /**
     * Retrieves the grade for a completed course, from the Session Database.
     *
     * @param requestModel the course Id
     * @return the numeric grade for this course.
     */
    @Override
    public int getPrerequisiteCourseGPA(EnrolmentDbRequestModel requestModel) {
        return 80;
    }

    /**
     * Saves course in Session Database.
     * @param requestModel the course ID
     */
    @Override
    public void saveCourse(EnrolmentDbRequestModel requestModel) {
        try {
            List<String> questions = requestModel.getQuestions();
            List<Integer> points = requestModel.getPoints();

            for (int j = 0; j < questions.size(); j++) {
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO " + DATABASE_NAME_COURSE + " (CourseID, Question, Answer, Points) VALUES (?, ?, ?, ?)");
                statement.setString(1, requestModel.getCourseID());
                statement.setString(2, questions.get(j));
                statement.setString(3, "");
                statement.setString(4, points.get(j).toString());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
    }

    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    public void saveUser(LoginStudentDbRequestModel requestModel) {
        try {
            Map<String, Integer> courses = requestModel.getCourses();

            for (Map.Entry<String, Integer> course : courses.entrySet()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO " + DATABASE_NAME_STUDENT + " (StudentID, CourseID, CourseGrade) VALUES (?, ?, ?)");
                statement.setString(1, requestModel.getUsername());
                statement.setString(2, course.getKey());
                statement.setString(3, course.getValue().toString());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with the database");
            e.printStackTrace();
        }
    }

    public List<String> getCourseQuestions() {
        List<String> questions = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + DATABASE_NAME_COURSE);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                questions.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
        return questions;
    }

    public void deleteStudentSession() {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + DATABASE_NAME_STUDENT);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
    }

    public void deleteCourseSession() {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + DATABASE_NAME_COURSE);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
        }
    }

    @Override
    public void saveAnswers(RunCourseDbRequestModel requestModel) {
        try {
            List<String> questions = requestModel.getQuestions();
            List<String> answers = requestModel.getAnswers();

            for (int j = 0; j < questions.size(); j++) {
                PreparedStatement statement = connection.prepareStatement("UPDATE " + DATABASE_NAME_COURSE + " SET Answer = ? WHERE Question = ?");
                statement.setString(1, answers.get(j));
                statement.setString(2, questions.get(j));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }

    @Override
    public EvaluatorDbResponseModel retrieveCourse() {
        EvaluatorDbResponseModel responseModel = new EvaluatorDbResponseModel();
        try {
            List<String> questions = new ArrayList<>();
            List<String> answers = new ArrayList<>();
            List<Integer> points = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + DATABASE_NAME_COURSE);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            responseModel.setCourseId(resultSet.getString(1));

            do {
                questions.add(resultSet.getString(2));
                answers.add(resultSet.getString(3));
                points.add(resultSet.getInt(4));
            } while (resultSet.next());

            responseModel.setQuestions(questions);
            responseModel.setAnswers(answers);
            responseModel.setPoints(points);
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
        return responseModel;
    }

    @Override
    public String retrieveStudentId() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT StudentID FROM " + DATABASE_NAME_STUDENT);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            return resultSet.getString(1);
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
        return "";
    }
}
