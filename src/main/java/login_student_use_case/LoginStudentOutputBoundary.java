package login_student_use_case;

public interface LoginStudentOutputBoundary {
    LoginStudentResponseModel prepareSuccessView(LoginStudentResponseModel responseModel);

    LoginStudentResponseModel prepareFailView(String error);
}
