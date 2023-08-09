package frameworksdrivers.gateways;

import usecases.CourseEnrollmentUseCase.EnrolmentSessionDataAccess;
import usecases.CourseEvaluatorUseCase.EvaluatorSessionDataAccess;
import usecases.LoginStudentUseCase.LoginSessionDataAccess;
import usecases.RunCourseUseCase.RunCourseSessionDataAccess;

/**
 * Gateway that accesses and interacts with the Course Database. Extends the interfaces: LoginSessionDataAccess,
 * EnrolmentSessionDataAccess, RunCourseSessionDataAccess, and EvaluatorSessionDataAccess. This creates a single
 * interface for all the required methods for the gateway.
 */
public interface SessionGateway extends LoginSessionDataAccess, EnrolmentSessionDataAccess,
        RunCourseSessionDataAccess, EvaluatorSessionDataAccess {
}
