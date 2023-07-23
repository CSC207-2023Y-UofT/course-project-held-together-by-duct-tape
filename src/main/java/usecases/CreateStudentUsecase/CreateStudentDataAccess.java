package usecases.CreateStudentUsecase;
/** This interface must be implemented by the StudentDbGateway to ensure a seperation of concerns and
 * to adhere to clean architecture*/
public interface CreateStudentDataAccess {
    /** Method returns whether the username is unique meaning that it's not already present in the database
     * @param username is the username that is checked for whether it is unique*/
    boolean isUnique(String username);
    /** Method saves the user info stored in "student" to the database
     *@param student this a model that stores what will be saved onto the database*/
    void save(CreateStudentDsModel student);
}