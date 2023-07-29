package frameworksdrivers;

import usecases.CourseEvaluator.StudentDataAccess;
import usecases.CreateStudentUsecase.CreateStudentDataAccess;
import usecases.LoginStudentUseCase.LoginStudentDataAccess;

public interface StudentGateway extends LoginStudentDataAccess, CreateStudentDataAccess, StudentDataAccess {
}
