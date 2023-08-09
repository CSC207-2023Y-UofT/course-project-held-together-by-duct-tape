package usecases.runCourseUseCase;

import java.util.List;

public class RunCourseDbRequestModel {
    private final List<String> questions;
    private final List<String> answers;

    public RunCourseDbRequestModel(List<String> questions, List<String> answers){
        this.questions = questions;
        this.answers = answers;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
