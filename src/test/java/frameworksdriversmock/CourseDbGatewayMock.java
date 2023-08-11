package frameworksdriversmock;

import frameworksdrivers.gateways.CourseGateway;
import usecases.courseEnrollmentUseCase.EnrolmentDbRequestModel;
import usecases.courseEvaluatorUseCase.EvaluatorDbResponseModel;
import usecases.createCourseUseCase.CourseDbRequestModel;

import java.util.ArrayList;
import java.util.List;

    public class CourseDbGatewayMock implements CourseGateway {
    private final List<String> courseIDs = new ArrayList<>();
    private final List<String> prerequisiteIDs = new ArrayList<>();
    private final List<Integer> prerequisiteGrades = new ArrayList<>();
    private final List<List<String>> allQuestions = new ArrayList<>();
    private final List<List<String>> allAnswers = new ArrayList<>();
    private final List<List<Integer>> allPoints = new ArrayList<>();

    public CourseDbGatewayMock() {
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        questions.add("What is 2 + 2");
        questions.add("What is 14 + 14");
        answers.add("4");
        answers.add("14");
        points.add(5);
        points.add(4);
        addCourse("CSC108", "", 0, questions, answers, points);
    }

    public void addCourse(String courseID, String prerequisiteID, int prerequisiteGrade, List<String> questions,
                          List<String> answers, List<Integer> points) {
        courseIDs.add(courseID);
        prerequisiteIDs.add(prerequisiteID);
        prerequisiteGrades.add(prerequisiteGrade);
        allQuestions.add(questions);
        allAnswers.add(answers);
        allPoints.add(points);
    }

    @Override
    public boolean existsByCourseId(String courseID) {
        return courseIDs.contains(courseID);
    }

    @Override
    public void saveCourse(CourseDbRequestModel course) {
       courseIDs.add(course.getCourseId());
       prerequisiteIDs.add(course.getPrereq());
       prerequisiteGrades.add(Math.round(course.getPrereqGrade()));
       allQuestions.add(course.getQuestions());
       allAnswers.add(course.getAnswers());
       allPoints.add(course.getPoints());}


    @Override
    public void retrieveCourse(EnrolmentDbRequestModel requestModel) {
        int courseIndex = courseIDs.indexOf(requestModel.getCourseID());
        requestModel.setPrerequisiteID(prerequisiteIDs.get(courseIndex));
        requestModel.setPrerequisiteGrade(prerequisiteGrades.get(courseIndex));
        requestModel.setQuestions(allQuestions.get(courseIndex));
        requestModel.setPoints(allPoints.get(courseIndex));
    }

    @Override
    public List<String> getCourseIDs() {
        return courseIDs;
    }

    @Override
    public void findCourse(EvaluatorDbResponseModel responseModel) {
        int courseIndex = courseIDs.indexOf(responseModel.getCourseId());
        responseModel.setQuestions(allQuestions.get(courseIndex));
        responseModel.setAnswers(allAnswers.get(courseIndex));
        responseModel.setPoints(allPoints.get(courseIndex));

    }
}
