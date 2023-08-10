package usecases.createCourseUseCase;

/**
 * This interface provides methods to access and manipulate course data in the database.
 * Implementing classes should interact with the database to check for course existence
 * and save course information.
 */
public interface CourseDataAccess {
    /**
     * Checks whether a course with the specified course ID exists in the database.
     *
     * @param courseId The unique identifier of the course.
     * @return `true` if a course with the given course ID exists, otherwise `false`.
     */
    boolean existsByCourseId(String courseId);

    /**
     * Saves the details of a course in the database.
     *
     * @param course The data model representing the course to be saved.
     */
    void saveCourse(CourseDbRequestModel course);
}
