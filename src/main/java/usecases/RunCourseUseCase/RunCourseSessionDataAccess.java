package usecases.RunCourseUseCase;

import java.util.List;

public interface RunCourseSessionDataAccess {
    void saveAnswers(RunCourseDbRequestModel requestModel);
    void deleteCourseSession();
    List<String> getCourseQuestions();
}