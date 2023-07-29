package usecases.CourseEvaluatorUseCase;
import entities.Course;


public class CheckAnswer {

    public int compare(Course student, Course original) {

        int counter = 0;

        for (int i = 0; i < student.getQuestions().size(); i++){
            if ((student.getQuestionAt(i).getAnswer()).equalsIgnoreCase
                    ((original.getQuestionAt(i).getAnswer()))){
                counter += original.getQuestionAt(i).getPoints();
            }

        }
        return (counter / original.getAllPoints()) * 100;
    }




}
