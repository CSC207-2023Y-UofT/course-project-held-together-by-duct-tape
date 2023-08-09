package frameworksdrivers.gateways;

import usecases.courseEnrollmentUseCase.EnrolmentSessionDataAccess;
import usecases.courseEvaluatorUseCase.EvaluatorSessionDataAccess;
import usecases.loginStudentUseCase.LoginSessionDataAccess;
import usecases.runCourseUseCase.RunCourseSessionDataAccess;

/**
 * Gateway that accesses and interacts with the Course Database. Extends the interfaces: LoginSessionDataAccess,
 * EnrolmentSessionDataAccess, RunCourseSessionDataAccess, and EvaluatorSessionDataAccess. This creates a single
 * interface for all the required methods for the gateway.
 */
public interface SessionGateway extends LoginSessionDataAccess, EnrolmentSessionDataAccess,
        RunCourseSessionDataAccess, EvaluatorSessionDataAccess {
}
