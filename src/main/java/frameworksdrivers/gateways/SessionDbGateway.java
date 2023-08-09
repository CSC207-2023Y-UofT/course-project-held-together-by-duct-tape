package frameworksdrivers.gateways;

import frameworksdrivers.DbConnection;
import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.CourseEvaluatorUseCase.EvaluatorDbRequestModel;
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
     * Checks both if the student has completed the prerequisite course and if they have obtained the prerequisite
     * grade..
     *
     * @param requestModel data structure model with the course ID, prerequisite course ID, and prerequisite grade.
     * @return true if student has completed the course with the required grade, false otherwise.
     */
    @Override
    public boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel) {
        try {
            String SQL = "SELECT CourseID, CourseGrade FROM " + DATABASE_NAME_STUDENT + " WHERE CourseID=?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, requestModel.getPrerequisiteID());
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return false;
            }

            return resultSet.getInt(2) >= requestModel.getPrerequisiteGrade();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Saves course in Session Database.
     *
     * @param requestModel the model with all the information to be saved: the questions, answers.
     */
    @Override
    public void saveCourse(EnrolmentDbRequestModel requestModel) {
        try {
            List<String> questions = requestModel.getQuestions();
            List<Integer> points = requestModel.getPoints();

            for (int j = 0; j < questions.size(); j++) {
                String SQL = "INSERT INTO " + DATABASE_NAME_COURSE +
                        " (CourseID, Question, Answer, Points) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(SQL);
                statement.setString(1, requestModel.getCourseID());
                statement.setString(2, questions.get(j));
                statement.setString(3, "");
                statement.setString(4, points.get(j).toString());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }

    /**
     * Save the student's information to the session database such that the student
     * remains logged in until they decide to log out of the program.
     *
     * @param requestModel student username.
     */
    @Override
    public void saveUser(LoginStudentDbRequestModel requestModel) {
        try {
            Map<String, Float> courses = requestModel.getCourses();

            for (Map.Entry<String, Float> course : courses.entrySet()) {
                String SQL = "INSERT INTO " + DATABASE_NAME_STUDENT +
                        " (StudentID, Password, CourseID, CourseGrade) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(SQL);
                statement.setString(1, requestModel.getUsername());
                statement.setString(2, requestModel.getPassword());
                statement.setString(3, course.getKey());
                statement.setFloat(4, course.getValue());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with the database");
            e.printStackTrace();
        }
    }

    /**
     * Obtains the course questions from the session database. Since there can only be one course on the session
     * database at a time, a course id is not required as an input parameter since the questions are retrieved
     * from the only course in there.
     *
     * @return List of Strings representing the courses questions.
     */
    @Override
    public List<String> getCourseQuestions() {
        List<String> questions = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM " + DATABASE_NAME_COURSE;
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                questions.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
        return questions;
    }

    /**
     * Delete the current user on the session database. This method is called after a user logs out of the program.
     * This method is also called during initialization of the databases: when the program shuts down or is exited
     * incorrectly, there may be data in the session database at the start of the program which would need
     * to be deleted.
     */
    @Override
    public void deleteStudentSession() {
        try {
            String SQL = "TRUNCATE " + DATABASE_NAME_STUDENT;
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }

    /**
     * Delete the current course on the session database. This method is called after a user completes the course,
     * receives a grade, and is automatically un-enrolled from the course. This method is also called during
     * initialization of the databases: when the program shuts down or is exited incorrectly, there may be data in the
     * session database at the start of the program which would need to be deleted.
     */
    @Override
    public void deleteCourseSession() {
        try {
            String SQL = "TRUNCATE " + DATABASE_NAME_COURSE;
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }

    /**
     * Saves the students answers to the session database.
     *
     * @param requestModel data structure with the questions and answers to be saved.
     */
    @Override
    public void saveAnswers(RunCourseDbRequestModel requestModel) {
        try {
            List<String> questions = requestModel.getQuestions();
            List<String> answers = requestModel.getAnswers();

            for (int j = 0; j < questions.size(); j++) {
                String SQL = "UPDATE " + DATABASE_NAME_COURSE + " SET Answer = ? WHERE Question = ?";
                PreparedStatement statement = connection.prepareStatement(SQL);
                statement.setString(1, answers.get(j));
                statement.setString(2, questions.get(j));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the current course from the session database. This represents the course that the student has
     * answered.
     *
     * @return EvaluatorDbResponseModel with the questions, answers, and points per question.
     */
    @Override
    public EvaluatorDbResponseModel retrieveCourse() {
        EvaluatorDbResponseModel responseModel = new EvaluatorDbResponseModel();
        try {
            List<String> questions = new ArrayList<>();
            List<String> answers = new ArrayList<>();
            List<Integer> points = new ArrayList<>();

            String SQL = "SELECT * FROM " + DATABASE_NAME_COURSE;
            PreparedStatement statement = connection.prepareStatement(SQL);
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

    /**
     * Retrieves the courseID of the current user logged in. There can only be one user in the session database thus
     * it returns the only username on the database.
     */
    @Override
    public void retrieveUser(EvaluatorDbRequestModel requestModel) {
        try {
            String SQL = "SELECT DISTINCT StudentID, Password FROM " + DATABASE_NAME_STUDENT;
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            requestModel.setStudentID(resultSet.getString(1));
            requestModel.setPassword(resultSet.getString(2));
        } catch (SQLException e) {
            System.out.println("Error with the database!");
            e.printStackTrace();
        }
    }
}
