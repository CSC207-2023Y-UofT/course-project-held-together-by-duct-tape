package usecases.RunCourseUseCase;

import entities.Prerequisite;
import java.util.List;
public class RunCourseRequestModel {
    private String id;
    private List<String> questions;
    private List<String> answers;
    private List<Integer> points;

    public RunCourseRequestModel(String id, List<String> questions, List<String> answers, List<Integer> points){
        this.id = id;
        this.questions = questions;
        this.answers = answers;
        this.points = points;
    }
    public String getId(){
        return this.id;
    }
    public List<String> getQuestions(){
        return this.questions;
    }
    public List<String> getAnswers(){
        return this.answers;
    }
    public List<Integer> getPoints(){
        return this.points;
    }
    public boolean answersValid(List<String> answers){
        for (int i = 0; i < answers.size(); i++){
            if (answers.get(i).equals("")){
                return false;
            }
        }
        return true;
    }
}
