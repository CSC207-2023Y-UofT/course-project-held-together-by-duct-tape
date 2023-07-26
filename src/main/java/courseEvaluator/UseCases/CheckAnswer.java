package courseEvaluator.UseCases;
import entities.Course;

//-compares the answers from original course to the student course
//-generates a GPA
//interacts with
//EvaluatorInteractor
//GPAFactory?? non exsitant
public class CheckAnswer {
    private Course Answers;
    private int points;
    private EvaluatorDbResponseModel studentAnswers;

    public CheckAnswer(Course Answers, EvaluatorDbResponseModel studentAnswers) {
        this.Answers = Answers;
        this.studentAnswers = studentAnswers;
        this.points = 0;

    }


        // how is questions set up ?? {(question, answer), .... )} ??
        //String orgialAnswers = Answers.getAnswer();


}
