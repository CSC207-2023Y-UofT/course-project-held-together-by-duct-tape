package useCases.runCourseUseCase;

import java.util.List;

public class RunCourseRequestModel {
    private final List<String> questions;
    private final List<String> answers;

    public RunCourseRequestModel(List<String> questions, List<String> answers){
        this.questions = questions;
        this.answers = answers;
    }

    public List<String> getQuestions() { return questions; }

    public List<String> getAnswers() { return this.answers; }
}
