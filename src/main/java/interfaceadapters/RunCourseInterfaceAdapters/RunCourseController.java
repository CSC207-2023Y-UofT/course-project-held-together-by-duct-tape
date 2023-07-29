package interfaceadapters.RunCourseInterfaceAdapters;

import usecases.RunCourseUseCase.RunCourseInteractor;
import usecases.RunCourseUseCase.RunCourseRequestModel;

import java.util.List;

public class RunCourseController {
    private final RunCourseInteractor interactor;

    public RunCourseController(RunCourseInteractor interactor) {
        this.interactor = interactor;
    }

    public String runCourse(List<String> questions, List<String> answers) {
        RunCourseRequestModel requestModel = new RunCourseRequestModel(questions, answers);
        return interactor.runCourse(requestModel);
    }
}
