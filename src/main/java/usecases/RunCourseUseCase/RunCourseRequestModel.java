package usecases.RunCourseUseCase;

import java.util.List;

public class RunCourseRequestModel {
    private final List<String> answers;

    public RunCourseRequestModel(List<String> answers){
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return this.answers;
    }
}
