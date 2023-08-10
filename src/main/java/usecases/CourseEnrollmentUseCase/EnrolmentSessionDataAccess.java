package usecases.CourseEnrollmentUseCase;

/**
 * The interface which separates the enrollment interactors from the implementation of the session gateway, so that
 * the use case layer does not depend on the gateway.
 */
public interface EnrolmentSessionDataAccess {

    /**
     * Checks both if the student has completed the prerequisite course and if they have obtained the prerequisite
     * grade..
     *
     * @param requestModel data structure model with the course ID, prerequisite course ID, and prerequisite grade.
     * @return true if student has completed the course with the required grade, false otherwise.
     */
    boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel);

    /**
     * Saves course in Session Database.
     *
     * @param requestModel the model with all the information to be saved: the questions, answers.
     */
    void saveCourse(EnrolmentDbRequestModel requestModel);

    /**
     * Delete the current course on the session database. This method is called after a user completes the course,
     * receives a grade, and is automatically un-enrolled from the course. This method is also called during
     * initialization of the databases: when the program shuts down or is exited incorrectly, there may be data in the
     * session database at the start of the program which would need to be deleted.
     */
    void deleteCourseSession();

    /**
     * Delete the current user on the session database. This method is called after a user logs out of the program.
     * This method is also called during initialization of the databases: when the program shuts down or is exited
     * incorrectly, there may be data in the session database at the start of the program which would need
     * to be deleted.
     */
    void deleteStudentSession();
}
