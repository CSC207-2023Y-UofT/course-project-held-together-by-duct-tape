package frameworksdriversmock;

import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.CourseEnrollmentUseCase.EnrolmentSessionDataAccess;
import usecases.LoginStudentUseCase.LoginSessionDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;

public class SessionDbGatewayMock implements LoginSessionDataAccess, EnrolmentSessionDataAccess {
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
}
