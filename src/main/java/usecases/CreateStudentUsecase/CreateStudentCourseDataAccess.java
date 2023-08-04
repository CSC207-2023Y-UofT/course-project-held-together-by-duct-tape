package usecases.CreateStudentUsecase;

import java.util.*;

/**
 * This interface accesses the necessary information that the CreateStudentInteractor
 * would need from the course database to create a new user.
 */
public interface CreateStudentCourseDataAccess {
    /**
     * This method retrieves a list of all the course Ids that are currently stored in the Course database
     *
     * @return List of Strings representing the course ids.
     */
    List<String> getCourseIDs();}
