package frameworksdriversmock;

import frameworksdrivers.SessionGateway;
import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.CourseEvaluatorUseCase.EvaluatorDbResponseModel;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;
import usecases.RunCourseUseCase.RunCourseDbRequestModel;

public class SessionDbGatewayMock implements SessionGateway {
    @Override
    public boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel) {
        return false;
    }

    @Override
    public int getPrerequisiteCourseGPA(EnrolmentDbRequestModel requestModel) {
        return 0;
    }

    @Override
    public void saveCourse(EnrolmentDbRequestModel requestModel) {}

    @Override
    public void deleteCourseSession() {}

    @Override
    public void saveUser(LoginStudentDbRequestModel requestModel) {}

    @Override
    public EvaluatorDbResponseModel retrieveCourse() {
        return null;
    }

    @Override
    public String retrieveStudentId() {
        return null;
    }

    @Override
    public void saveAnswers(RunCourseDbRequestModel requestModel) {

    }
}
