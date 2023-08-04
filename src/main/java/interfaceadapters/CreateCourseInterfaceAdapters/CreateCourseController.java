package interfaceadapters.CreateCourseInterfaceAdapters;

import usecases.InstructorCreateCourseUseCase.CreateCourseInputBoundary;
import usecases.InstructorCreateCourseUseCase.CreateCourseRequestModel;

import java.util.List;

public class CreateCourseController {
    private final CreateCourseInputBoundary createCourseInteractor;

    public CreateCourseController(CreateCourseInputBoundary createCourseInteractor) {
        this.createCourseInteractor = createCourseInteractor;
    }

    public void createCourse(String courseId, String prerequisite, Float prerequisite_grade, List<String> questions,
                             List<String> answers, List<Integer> points) {
        Float prerequisite_gradeValue = prerequisite_grade;
        String prereq = prerequisite;
        if (prerequisite_grade == null & prereq != null) {
            prerequisite_gradeValue = 50f;}
        if ( prerequisite == null){ prereq = ""; prerequisite_gradeValue = 0f;}

        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prereq, prerequisite_gradeValue,
                questions, answers, points);
        createCourseInteractor.createCourse(request);
    }
}
