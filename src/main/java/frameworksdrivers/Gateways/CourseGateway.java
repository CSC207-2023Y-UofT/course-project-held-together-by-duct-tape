package frameworksdrivers.Gateways;

import usecases.CourseEnrollmentUseCase.EnrolmentCourseDataAccess;
import usecases.CourseEvaluatorUseCase.EvaluatorCourseDataAccess;
import usecases.CreateStudentUsecase.CreateStudentCourseDataAccess;
import usecases.InstructorCreateCourseUseCase.CourseDataAccess;

/**
 * Gateway that accesses and interacts with the Course Database. Extends the interfaces: EnrolmentCourseDataAccess,
 * CreateStudentCourseDataAccess, and EvaluatorCourseDataAccess. This creates a single interface for all the
 * required methods for the gateway.
 */
public interface CourseGateway extends EnrolmentCourseDataAccess, CreateStudentCourseDataAccess,
        EvaluatorCourseDataAccess, CourseDataAccess {
}
