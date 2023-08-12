package frameworksDrivers.gateways;

import useCases.courseEvaluatorUseCase.EvaluatorStudentDataAccess;
import useCases.createStudentUsecase.CreateStudentDataAccess;
import useCases.loginStudentUseCase.LoginStudentDataAccess;

/**
 * Gateway that accesses and interacts with the Course Database. Extends the interfaces: LoginStudentDataAccess,
 * CreateStudentDataAccess, and EvaluatorStudentDataAccess. This creates a single interface for all the required
 * methods for the gateway.
 */
public interface StudentGateway extends LoginStudentDataAccess, CreateStudentDataAccess, EvaluatorStudentDataAccess {
}
