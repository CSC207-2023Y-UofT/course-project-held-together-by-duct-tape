package interfaceadapters.CreateCourseInterfaceAdapters;

import usecases.InstructorCreateCourseUseCase.CreateCourseInputBoundary;
import usecases.InstructorCreateCourseUseCase.CreateCourseRequestModel;

import java.util.List;

/**
 * Controller for the course creation use case. The controller prepares a request model with the provided information
 * and delegates the course creation task to the interactor.
 * /** Initiates the course creation process by building a request model with the given parameters. The prerequisite
 *      * grade is processed, defaulting to a passing grade if not provided. The request model is then passed to the
 *      * interactor to create the course.
 *      * courseId         The unique identifier for the new course.
 *      * prerequisite     The identifier of the prerequisite course, if any.
 *      * prerequisite_grade The grade required in the prerequisite course.
 *      * questions        A list of questions associated with the course.
 *      * answers          A list of answers corresponding to the questions.
 *      * points           A list of points or scores assigned to each question.
 *      */

public class CreateCourseController {
    private final CreateCourseInputBoundary createCourseInteractor;

    Float passgrade = 50.0f;
    Float noGrade = 0.0f;
    /**
     * Constructor to initialize the CreateCourseController with the provided CreateCourseInputBoundary interactor.
     *
     * @param createCourseInteractor The interactor responsible for handling course creation.
     */
    public CreateCourseController(CreateCourseInputBoundary createCourseInteractor) {
        this.createCourseInteractor = createCourseInteractor;
    }





    /**
     * Converts the prerequisite grade value from a string representation to a Float value. If the string is empty,
     * the default grade (passgrade) is used.
     *
     * @param prerequisite_grade The grade required in the prerequisite course.
     */

    public String createCourse(String courseId, String prerequisite, String prerequisite_grade, List<String> questions,
                             List<String> answers, List<Integer> points) {
        Float prerequisite_gradeValue = noGrade;
        String prereq = prerequisite;
        if (!prerequisite.isEmpty() & prerequisite_grade.isEmpty()){ prerequisite_gradeValue = passgrade;}
        if ( prerequisite.equals("") ){ prereq = "";}
        else if(!prerequisite.isEmpty() & !prerequisite_grade.isEmpty()) {
            prerequisite_gradeValue = Float.valueOf(prerequisite_grade);}
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prereq, prerequisite_gradeValue,
                questions, answers, points);
        return createCourseInteractor.createCourse(request);
    }
}
