/**
 * This class represents an interactor for the "Create Course" use case.
 * It handles the creation of a new course, performing necessary validations and interactions with the data access layer.
 */
package usecases.createCourseUseCase;

import java.util.*;

public class CreateCourseInteractor implements CreateCourseInputBoundary {
    private final CourseDataAccess courseDataAccess;
    private final CreateCourseOutputBoundary presenter;


    /**
     * Constructs a CreateCourseInteractor with the provided dependencies.
     *
     * @param courseDataAccess The data access object responsible for managing course data.
     * @param presenter The presenter interface for displaying output and errors.
     */
    public CreateCourseInteractor(CourseDataAccess courseDataAccess, CreateCourseOutputBoundary presenter) {
        this.courseDataAccess = courseDataAccess;
        this.presenter = presenter;
    }


    /**
     * Creates a new course based on the provided request model.
     *
     * @param request The request model containing information for creating the course.
     */
    @Override
    public String createCourse(CreateCourseRequestModel request) {
        // Extract information from the request
        String courseId = request.getCourseId();
        String prerequisite = request.getPrerequisite();
        Float prerequisite_grade = request.getPrerequisite_grade();
        List<String> questions = request.getQuestions();
        List<String> answers = request.getAnswers();
        List<Integer> points = request.getPoints();

        // Validate courses and prerequisites
        checkCoursesAndPrereqs(courseId, prerequisite, prerequisite_grade);

        // Validate questions, answers, and points
        checkQuestionsAnswersPoints(questions, answers, points);

        // Prepare database request model
        CourseDbRequestModel courseDbRequestModel =
                new CourseDbRequestModel(courseId, prerequisite, prerequisite_grade, questions, answers, points);

        // Save the course
        courseDataAccess.saveCourse(courseDbRequestModel);

        // Notify presenter about successful course creation
        CreateCourseResponseModel response = new CreateCourseResponseModel(courseId);
        return presenter.courseCreated(response);
    }

    /** Private helper methods for validation*/
    private void checkCoursesAndPrereqs(String courseId, String prerequisite, Float prerequisite_grade){
        // Check if the course already exists
        if (courseDataAccess.existsByCourseId(courseId) || courseId.isEmpty()) {
            presenter.showError("Course with this name already exists, Or you gave an empty input.");
        }

        // Check if prerequisite exists in the database
        if (!prerequisite.isEmpty() && !courseDataAccess.existsByCourseId(prerequisite)) {
            presenter.showError("Prerequisite course not found in the database.");
        }

        // Check prerequisite grade
        if (prerequisite_grade < 0) {
            presenter.showError("Prerequisite's Grade must be positive numbers.");
        }
    }

    private void checkQuestionsAnswersPoints(List<String> questions, List<String> answers, List<Integer> points){

        // Check for empty questions
        for (String question : questions) {
            if (question.isEmpty()) {
                presenter.showError("All questions must be filled.");
            }
        }
        // Check for empty answers
        for (String answer : answers) {
            if (answer.isEmpty()) {
                presenter.showError("All answers must be filled.");
            }
        }
        // Check for non-positive points
        for (Integer point : points) {
            if (point == null || point < 0) {
                presenter.showError("Points must be positive for all questions.");
            }
        }
    }
}
