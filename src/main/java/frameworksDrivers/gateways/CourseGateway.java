package frameworksDrivers.gateways;

import useCases.courseEnrollmentUseCase.EnrolmentCourseDataAccess;
import useCases.courseEvaluatorUseCase.EvaluatorCourseDataAccess;
import useCases.createStudentUsecase.CreateStudentCourseDataAccess;
import useCases.createCourseUseCase.CourseDataAccess;

/**
 * Gateway that accesses and interacts with the Course Database. Extends the interfaces: EnrolmentCourseDataAccess,
 * CreateStudentCourseDataAccess, and EvaluatorCourseDataAccess. This creates a single interface for all the
 * required methods for the gateway.
 */
public interface CourseGateway extends EnrolmentCourseDataAccess, CreateStudentCourseDataAccess,
        EvaluatorCourseDataAccess, CourseDataAccess {
}
