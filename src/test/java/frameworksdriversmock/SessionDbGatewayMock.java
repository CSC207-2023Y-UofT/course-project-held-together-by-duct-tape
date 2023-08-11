package frameworksdriversmock;

import frameworksdrivers.gateways.SessionGateway;
import usecases.courseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.courseEvaluatorUseCase.EvaluatorDbRequestModel;
import usecases.courseEvaluatorUseCase.EvaluatorDbResponseModel;
import usecases.loginStudentUseCase.LoginStudentDbRequestModel;
import usecases.runCourseUseCase.RunCourseDbRequestModel;

import java.util.ArrayList;
import java.util.List;

public class SessionDbGatewayMock implements SessionGateway {
    private final String username;
    private final String password;
    private final List<String> courseIDs;
    private final List<Float> courseGrades;
    private final String courseID;
    private final List<String> questions;
    private final List<String> answers;
    private final List<Integer> points;

    public SessionDbGatewayMock() {
        username = "jpmedina";
        password = "gmpj";
        courseIDs = new ArrayList<>();
        courseGrades = new ArrayList<>();
        courseIDs.add("CSC108");
        courseIDs.add("CSC148");
        courseIDs.add("CSC207");

        courseGrades.add(60.0f);
        courseGrades.add(40.0f);
        courseGrades.add(0.0f);

        courseID = "CSC108";
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        points = new ArrayList<>();
        questions.add("What is 2+2?");
        answers.add("4");
        points.add(2);
        questions.add("What is 7+7?");
        answers.add("14");
        points.add(5);
    }

    @Override
    public boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel) {
        if (!courseIDs.contains(requestModel.getPrerequisiteID())) {
            return false;
        }
        int courseIndex = courseIDs.indexOf(requestModel.getPrerequisiteID());
        return courseGrades.get(courseIndex) >= requestModel.getPrerequisiteGrade();
    }

    @Override
    public List<String> getCourseQuestions() {
        return questions;
    }

    @Override
    public EvaluatorDbResponseModel retrieveCourse() {
        EvaluatorDbResponseModel responseModel = new EvaluatorDbResponseModel();
        responseModel.setCourseId(courseID);
        responseModel.setQuestions(questions);
        responseModel.setAnswers(answers);
        responseModel.setPoints(points);
        return responseModel;
    }

    @Override
    public void retrieveUser(EvaluatorDbRequestModel requestModel) {
        requestModel.setStudentID(username);
        requestModel.setPassword(password);
    }

    @Override
    public void saveUser(LoginStudentDbRequestModel requestModel) {}

    @Override
    public void saveCourse(EnrolmentDbRequestModel requestModel) {}

    @Override
    public void saveAnswers(RunCourseDbRequestModel requestModel) {}

    @Override
    public void deleteCourseSession() {}

    @Override
    public void deleteStudentSession() {}
}
