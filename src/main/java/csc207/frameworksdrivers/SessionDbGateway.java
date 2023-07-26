package csc207.frameworksdrivers;

import csc207.courseenrolmentusecase.EnrolmentDataAccess;

/**
 * MOCK GATEWAY: Currently a mock gateway such that the interactor is able to perform
 * its function. Once the databases are chosen, the gateway will be modified.
 */
public class SessionDbGateway implements EnrolmentDataAccess {

    @Override
    public boolean hasCompletedCourse(String studentId, String courseId) {
        return true;
    }

    @Override
    public int getCourseGPA(String studentId, String courseId) {
        return 80;
    }

    @Override
    public void saveCourse(String studentId, String courseId) {

    }
}
