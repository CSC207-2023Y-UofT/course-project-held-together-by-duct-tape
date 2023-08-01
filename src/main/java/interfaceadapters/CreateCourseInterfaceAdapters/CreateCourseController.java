package interfaceadapters.CreateCourseInterfaceAdapters;

import usecases.InstructorCreateCourseUseCase.CreateCourseInputBoundary;
import usecases.InstructorCreateCourseUseCase.CreateCourseRequestModel;

import java.util.Collections;
import java.util.List;

public class CreateCourseController {
    private final CreateCourseInputBoundary createCourseInteractor;

    public CreateCourseController(CreateCourseInputBoundary createCourseInteractor) {
        this.createCourseInteractor = createCourseInteractor;
    }

    public void createCourse(String courseId, String prerequisite, List<String> questions, List<String> answers, List<Integer> points) {
        CreateCourseRequestModel request = new CreateCourseRequestModel(courseId, prerequisite, questions, answers, points);
        createCourseInteractor.createCourse(request);
    }
}
