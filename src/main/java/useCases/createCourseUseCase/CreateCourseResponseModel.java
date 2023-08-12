package useCases.createCourseUseCase;

/**
 * Represents the response model for the creation of a new course by an instructor.
 */
public class CreateCourseResponseModel {
    private final String courseId;


    /**
     * Constructor for initializing the CreateCourseResponseModel object.
     *
     * @param courseId The unique identifier of the newly created course.
     */
    public CreateCourseResponseModel(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Retrieves the course ID of the newly created course.
     *
     * @return The course ID as a String.
     */
    public String getCourseId() {
        return courseId;
    }
}
