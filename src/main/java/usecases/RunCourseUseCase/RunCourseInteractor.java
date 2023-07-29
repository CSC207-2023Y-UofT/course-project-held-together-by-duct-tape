package usecases.RunCourseUseCase;

import entities.Course;
import entities.CourseFactory;
import entities.Question;
import java.util.List;
import java.util.ArrayList;

public class RunCourseInteractor {
    private CourseFactory courseFactory;
    private RunCourseSessionDataAccess sessionDbGateway;
    private RunCourseOutputBoundary presenter;

    public RunCourseInteractor(CourseFactory courseFactory, RunCourseSessionDataAccess sessionDbGateway, RunCourseOutputBoundary presenter){
        this.courseFactory = courseFactory;
        this.sessionDbGateway = sessionDbGateway;
        this.presenter = presenter;
    }
    public boolean answersValid(List<String> answers) {
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).equals("")) {
                return false;
            }
        }
        return true;
    }

    public String runCourse(RunCourseRequestModel requestModel) {
        if (!answersValid(requestModel.getAnswers())){
            return presenter.failView("Answers can not be empty.");
        }

        Course course = CourseFactory.create(requestModel.getId(), requestModel.getQuestions(), requestModel.getAnswers(), requestModel.getPoints());

        List<Question> questions = course.getQuestions();
        List<String> answers = new ArrayList<String>(questions.size());
        List<Integer> points = new ArrayList<Integer>(questions.size());
        for (int i = 0; i < questions.size(); i++){
            Question question = course.getQuestionAt(i);
            answers.add(question.getAnswer());
            points.add(question.getPoints());
        }

        RunCourseDbRequestModel dbRequestModel = new RunCourseDbRequestModel(course.getCourseId(), course.getQuestions(), answers, points);
        sessionDbGateway.save(dbRequestModel);

        return presenter.successView("Course Completed.");
    }
}

