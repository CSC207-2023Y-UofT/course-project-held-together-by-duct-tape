package frameworksdrivers;

import usecases.CourseEnrollmentUseCase.EnrolmentCourseDataAccess;
import usecases.CourseEnrollmentUseCase.EnrolmentDbResponseModel;
import entities.Prerequisite;

import java.util.ArrayList;

/**
 * MOCK GATEWAY: Currently a mock gateway such that the interactor is able to perform
 * its function. Once the databases are chosen, the gateway will be modified.
 */
public class CourseDbGateway implements EnrolmentCourseDataAccess {

    /**
     * Checks if Id exists in Course Database.
     * @param courseId the course Id
     * @return true if the course is in Course Database, false if not.
     */
    @Override
    public boolean existsByCourseId(String courseId) {
        return true;
    }

    /**
     * Retrieves course from Course Database.
     * @param courseId the course Id
     * @return a response model containing the course.
     */
    @Override
    public EnrolmentDbResponseModel retrieveCourse(String courseId) {
        return new EnrolmentDbResponseModel(courseId, new ArrayList<>(),
                new Prerequisite("CSC108", 50));
    }

}
