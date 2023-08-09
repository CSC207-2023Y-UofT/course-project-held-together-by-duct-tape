package frameworksdrivers.gateways;

import usecases.courseEnrollmentUseCase.EnrolmentCourseDataAccess;
import usecases.courseEvaluatorUseCase.EvaluatorCourseDataAccess;
import usecases.createStudentUsecase.CreateStudentCourseDataAccess;

/**
 * Gateway that accesses and interacts with the Course Database. Extends the interfaces: EnrolmentCourseDataAccess,
 * CreateStudentCourseDataAccess, and EvaluatorCourseDataAccess. This creates a single interface for all the
 * required methods for the gateway.
 */
public interface CourseGateway extends EnrolmentCourseDataAccess, CreateStudentCourseDataAccess,
        EvaluatorCourseDataAccess {
}
