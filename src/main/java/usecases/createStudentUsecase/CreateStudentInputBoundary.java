package usecases.createStudentUsecase;

/**
 * Interface that an interactor implements to create an abstraction.
 */
public interface CreateStudentInputBoundary {
   /**
    * This is a use case in which a user can create a new Student profile
    * a "request" is passed through and contains the necessary information to create the user
    * if the user is successfully saved to the database a success message is shown otherwise a fail message
    * will be shown.
    *
    * @param request contains the necessary information that is needed to create a profile in the Student Database.
    * @return String of success of failure.
    */
   String createStudent(CreateStudentRequestModel request);
}
