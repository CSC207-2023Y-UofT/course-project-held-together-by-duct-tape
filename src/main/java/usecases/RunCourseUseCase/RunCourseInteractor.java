package usecases.RunCourseUseCase;

import java.util.List;

public class RunCourseInteractor {
    private final RunCourseSessionDataAccess sessionDbGateway;
    private final RunCourseOutputBoundary presenter;

    public RunCourseInteractor(RunCourseSessionDataAccess sessionDbGateway, RunCourseOutputBoundary presenter){
        this.sessionDbGateway = sessionDbGateway;
        this.presenter = presenter;
    }
    public boolean answersValid(List<String> answers) {
        for (String answer : answers) {
            if (answer.equals("")) {
                return false;
            }
        }
        return true;
    }

    public String runCourse(RunCourseRequestModel requestModel) {
        if (!answersValid(requestModel.getAnswers())){
            return presenter.failView("Answers can not be empty.");
        }

        RunCourseDbRequestModel dbRequestModel = new RunCourseDbRequestModel(requestModel.getQuestions(), requestModel.getAnswers());
        sessionDbGateway.saveAnswers(dbRequestModel);

        return presenter.successView("Course Completed.");
    }
}

