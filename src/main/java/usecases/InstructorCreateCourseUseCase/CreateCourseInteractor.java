package usecases.InstructorCreateCourseUseCase;
import entities.*;
import entities.CourseBuilder.CourseBuilder;

import java.util.*;

public class CreateCourseInteractor implements CreateCourseInputBoundary {
    private final CourseDataAccess courseDataAccess;
    private final CreateCourseOutputBoundary presenter;


/***/
    public CreateCourseInteractor(CourseDataAccess courseDataAccess, CreateCourseOutputBoundary presenter) {
        this.courseDataAccess = courseDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void createCourse(CreateCourseRequestModel request) {
        String courseId = request.getCourseId();
        String prerequisite = request.getPrerequisite();
        Float prerequisite_grade = request.getPrerequisite_grade();
        List<String> questions = request.getQuestions();
        List<String> answers = request.getAnswers();
        List<Integer> points = request.getPoints();
        checkCoursesAndPrereqs(courseId, prerequisite, prerequisite_grade);
        // Check if all questions, answers, and points are non-empty
        checkQuestionsAnswersPoints(questions, answers, points);
        CourseDbRequestModel courseDbRequestModel =
                new CourseDbRequestModel(courseId, prerequisite, prerequisite_grade, questions, answers, points);
        courseDataAccess.saveCourse(courseDbRequestModel);
        // Notify presenter about successful course creation
        CreateCourseResponseModel response = new CreateCourseResponseModel(courseId);
        presenter.courseCreated(response);}

    private void checkCoursesAndPrereqs(String courseId, String prerequisite, Float prerequisite_grade){
        if (courseDataAccess.existsByCourseId(courseId)) {
            presenter.showError("Course with this name already exists.");}

        // Check if prerequisite exists in the database
        if (!prerequisite.isEmpty() && !courseDataAccess.existsByCourseId(prerequisite)) {
            presenter.showError("Prerequisite course not found in the database.");}

        if (prerequisite_grade < 0){
            presenter.showError("Prerequisite's Grade must be positive numbers.");}
    }

    private void checkQuestionsAnswersPoints(List<String> questions, List<String> answers, List<Integer> points){
        for (String question : questions) {if (question.isEmpty()) {
            presenter.showError("All questions must be filled.");}}

        for (String answer : answers) {if (answer.isEmpty()) {
            presenter.showError("All answers must be filled.");}}

        for (Integer point : points) {if (point == null || point < 0) {
            presenter.showError("Points must be positive for all questions.");}}}
}
