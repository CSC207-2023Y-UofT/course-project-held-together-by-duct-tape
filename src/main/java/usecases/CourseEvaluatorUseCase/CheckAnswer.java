package usecases.CourseEvaluatorUseCase;

import entities.Course;
import entities.CourseFactory;

public class CheckAnswer {
    public static int compare(EvaluatorDbResponseModel studentResponseModel,
                              EvaluatorDbResponseModel courseResponseModel) {
        // Creates two course objects, original and the student
        Course student = CourseFactory.create(studentResponseModel.getCourseId(),
                studentResponseModel.getQuestions(), studentResponseModel.getAnswers(),
                studentResponseModel.getPoints());

        Course original = CourseFactory.create(courseResponseModel.getCourseId(),
                courseResponseModel.getQuestions(), courseResponseModel.getAnswers(),
                courseResponseModel.getPoints());

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
