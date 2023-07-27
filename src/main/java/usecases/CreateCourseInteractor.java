package usecases.InstructorCreateCoursesUseCase;
import entities.*;
import java.util.*;

public class CreateCourseInteractor implements CreateCourseInputBoundary {
    private final CourseDataAccess courseDataAccess;
    private final CreateCourseOutputBoundary presenter;

    public CreateCourseInteractor(CourseDataAccess courseDataAccess, CreateCourseOutputBoundary presenter) {
        this.courseDataAccess = courseDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void createCourse(CreateCourseRequestModel request) {
        String courseId = request.getCourseId();
        String prerequisite = request.getPrerequisite();
        List<String> questions = request.getQuestions();
        List<String> answers = request.getAnswers();
        List<Integer> points = request.getPoints();

        // Check if the course name already exists in the database
        if (courseDataAccess.courseExists(courseId)) {
            presenter.showError("Course with this name already exists.");
            return;
        }

        // Check if prerequisite exists in the database
        if (!prerequisite.isEmpty() && !courseDataAccess.courseExists(prerequisite)) {
            presenter.showError("Prerequisite course not found in the database.");
            return;
        }

        // Check if all questions, answers, and points are non-empty
        for (String question : questions) {
            if (question.isEmpty()) {
                presenter.showError("All questions must be filled.");
                return;
            }
        }

        for (String answer : answers) {
            if (answer.isEmpty()) {
                presenter.showError("All answers must be filled.");
                return;
            }
        }

        for (Integer point : points) {
            if (point == null || point <= 0) {
                presenter.showError("Points must be positive for all questions.");
                return;
            }
        }

        // All checks passed, create the course
        Prerequisite prerequisiteObj = new Prerequisite(prerequisite, 50); // Assuming default GPA is 50
        List<Question> questionObjs = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question questionObj = new Question(questions.get(i), answers.get(i), points.get(i));
            questionObjs.add(questionObj);
        }
        Course course = new Course(courseId, prerequisiteObj, questionObjs);
        courseDataAccess.saveCourse(course);

        // Notify presenter about successful course creation
        CreateCourseResponseModel response = new CreateCourseResponseModel(courseId);
        presenter.courseCreated(response);
    }
}
