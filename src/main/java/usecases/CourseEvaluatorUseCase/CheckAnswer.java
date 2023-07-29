package usecases.CourseEvaluatorUseCase;

import entities.Course;
import entities.CourseFactory;

import java.text.DecimalFormat;

public class CheckAnswer {
    public static float compare(EvaluatorDbResponseModel studentResponseModel,
                              EvaluatorDbResponseModel courseResponseModel) {
        // Creates two course objects, original and the student
        Course student = CourseFactory.create(studentResponseModel.getCourseId(),
                studentResponseModel.getQuestions(), studentResponseModel.getAnswers(),
                studentResponseModel.getPoints());

        Course original = CourseFactory.create(courseResponseModel.getCourseId(),
                courseResponseModel.getQuestions(), courseResponseModel.getAnswers(),
                courseResponseModel.getPoints());

        float counter = 0;

        for (int i = 0; i < student.getQuestions().size(); i++){
            if ((student.getQuestionAt(i).getAnswer()).equalsIgnoreCase
                    ((original.getQuestionAt(i).getAnswer()))){
                counter += original.getQuestionAt(i).getPoints();
            }

        }
        float grade = (counter / original.getAllPoints()) * 100;

        DecimalFormat df = new DecimalFormat("0.00");
        return Float.parseFloat(df.format(grade));
    }
}
