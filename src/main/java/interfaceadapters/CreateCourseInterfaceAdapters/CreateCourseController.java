package interfaceadapters.CreateCourseInterfaceAdapters;

import usecases.InstructorCreateCourseUseCase.CreateCourseInputBoundary;
import usecases.InstructorCreateCourseUseCase.CreateCourseRequestModel;

import java.util.List;

public class CreateCourseController {
    private final CreateCourseInputBoundary createCourseInteractor;
    Float passgrade = 50.0f;
    Float noGrade = 0.0f;
    public CreateCourseController(CreateCourseInputBoundary createCourseInteractor) {
        this.createCourseInteractor = createCourseInteractor;
    }

    public void createCourse(String courseId, String prerequisite, String prerequisite_grade, List<String> questions,
                             List<String> answers, List<Integer> points) {
        Float prerequisite_gradeValue = noGrade;
        String prereq = prerequisite;
        if (!prerequisite.isEmpty() & prerequisite_grade.isEmpty()){ prerequisite_gradeValue = passgrade;}
        if ( prerequisite.equals("") ){ prereq = "";}
        else if(!prerequisite.isEmpty() & !prerequisite_grade.isEmpty()) {
            prerequisite_gradeValue = Float.valueOf(prerequisite_grade);}
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prereq, prerequisite_gradeValue,
                questions, answers, points);
        createCourseInteractor.createCourse(request);
    }
}
