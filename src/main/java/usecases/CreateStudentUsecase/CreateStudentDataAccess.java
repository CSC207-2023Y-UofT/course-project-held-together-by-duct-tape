package usecases.CreateStudentUsecase;

public interface CreateStudentDataAccess {
    boolean isUnique(String username);
    void save(CreateStudentDsModel student);
}