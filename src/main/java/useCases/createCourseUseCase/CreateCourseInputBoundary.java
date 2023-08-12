package useCases.createCourseUseCase;


/**
 * This interface defines the input boundary for the use case of creating a new course by an instructor.
 * Implementing classes provide the logic to handle the creation of a course based on the provided request model.
 */
public interface CreateCourseInputBoundary {

   /**
    * Create a new course based on the information provided in the request model.
    *
    * @param request The request model containing the necessary information to create the course.
    */
   String createCourse(CreateCourseRequestModel request);
}

