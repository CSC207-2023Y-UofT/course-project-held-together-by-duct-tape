package usecases.RunCourseUseCase;

import java.util.List;

public class RunCourseDbRequestModel {
    private final List<String> answers;

    public RunCourseDbRequestModel(List<String> answers){
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
