package usecases.courseEvaluatorUseCase;

import entities.Course;
import entities.courseBuilder.CourseBuilder;
import entities.courseBuilder.CourseNoPrerequisiteBuilder;
import entities.CourseFactory;

import java.text.DecimalFormat;

public class CheckAnswer {
    public static float compare(EvaluatorDbResponseModel studentResponseModel,
                              EvaluatorDbResponseModel courseResponseModel) {
        // Creates two course objects, original and the student
        CourseBuilder courseStudentBuilder = new CourseNoPrerequisiteBuilder(studentResponseModel.getCourseId(), studentResponseModel.getQuestions(), studentResponseModel.getAnswers(),
                studentResponseModel.getPoints());
        CourseFactory courseFactory = new CourseFactory(courseStudentBuilder);
        courseFactory.create();

        Course student = courseStudentBuilder.getProduct();

        CourseBuilder courseOriginalBuilder = new CourseNoPrerequisiteBuilder(courseResponseModel.getCourseId(),
                courseResponseModel.getQuestions(), courseResponseModel.getAnswers(),
                courseResponseModel.getPoints());
        courseFactory.setBuilder(courseOriginalBuilder);
        courseFactory.create();

        Course original = courseOriginalBuilder.getProduct();

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
