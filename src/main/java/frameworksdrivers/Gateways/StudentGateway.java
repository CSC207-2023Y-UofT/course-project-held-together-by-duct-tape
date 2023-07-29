package frameworksdrivers.Gateways;

import usecases.CourseEvaluatorUseCase.StudentDataAccess;
import usecases.CreateStudentUsecase.CreateStudentDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDataAccess;

public interface StudentGateway extends LoginStudentDataAccess, CreateStudentDataAccess, StudentDataAccess {
}
