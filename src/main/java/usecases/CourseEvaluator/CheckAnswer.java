package usecases.CourseEvaluator;
import entities.Course;

import entities.Question;

//-compares the answers from original course to the student course
//-generates a GPA
//interacts with
//EvaluatorInteractor
//GPAFactory?? non exsitant
public class CheckAnswer {

    public int compare(Course student, Course original) {

        int counter = 0;

        for (int i = 0; i < student.getQuestions().size(); i++){
            if (student.getQuestionAt(i).getAnswer().equals(original.getQuestionAt(i).getAnswer())){
                counter += original.getQuestionAt(i).getPoints();
            }

        }
        return (counter / original.getAllPoints()) * 100;
    }


        // how is questions set up ?? {(question, answer), .... )} ??
        //String orgialAnswers = Answers.getAnswer();


}
