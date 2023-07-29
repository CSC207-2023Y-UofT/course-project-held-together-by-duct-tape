package usecases.CreateStudentUsecase;

/**
 * Interface that studentDbGateway must implement for the CreateStudentInteractor to
 * ensure clean architecture and call on its methods.
 */
public interface CreateStudentDataAccess {
    /**
     * Method returns whether the username is unique meaning that it's not already present in the database.
     *
     * @param username is the username that is checked.
     * @return boolean that indicates if username is unique.
     */
     boolean usernameExists(String username);

    /**
     * Method saves the user info stored in "student" to the database.
     *
     * @param student model that stores what will be saved onto the database.
     */
    void saveUser(CreateStudentDsModel student);
}