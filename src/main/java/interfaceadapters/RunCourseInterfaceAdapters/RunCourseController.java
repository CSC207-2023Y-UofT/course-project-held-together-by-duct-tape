package interfaceadapters.RunCourseInterfaceAdapters;

import usecases.RunCourseUseCase.RunCourseInputBoundary;
import usecases.RunCourseUseCase.RunCourseRequestModel;

import java.util.List;

public class RunCourseController {
    private final RunCourseInputBoundary interactor;

    public RunCourseController(RunCourseInputBoundary interactor) {
        this.interactor = interactor;
    }

    public String runCourse(List<String> questions, List<String> answers) {
        RunCourseRequestModel requestModel = new RunCourseRequestModel(questions, answers);
        return interactor.runCourse(requestModel);
    }
}
