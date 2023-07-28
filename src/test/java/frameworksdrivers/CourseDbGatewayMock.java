package frameworksdrivers;

import entities.Prerequisite;
import usecases.CourseEnrollmentUseCase.EnrolmentCourseDataAccess;
import usecases.CourseEnrollmentUseCase.EnrolmentDbRequestModel;

import java.util.ArrayList;
import java.util.List;

public class CourseDbGatewayMock implements EnrolmentCourseDataAccess {
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
        answers.add("4");
        points.add(5);
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
    public void retrieveCourse(EnrolmentDbRequestModel requestModel) {
        EnrolmentDbRequestModel dbRequestModel = new EnrolmentDbRequestModel(requestModel.getCourseID());

        int courseIndex = courseIDs.indexOf(requestModel.getCourseID());
        dbRequestModel.setPrerequisiteID(prerequisiteIDs.get(courseIndex));
        dbRequestModel.setPrerequisiteGrade(prerequisiteGrades.get(courseIndex));
        dbRequestModel.setQuestions(allQuestions.get(courseIndex));
        dbRequestModel.setPoints(allPoints.get(courseIndex));
    }

    @Override
    public List<String> getCourseIDs() {
        return courseIDs;
    }
}
