package usecases.CourseEnrollmentUseCase;


import entities.Question;

import java.util.List;

public interface EnrolmentDataAccess {
    public boolean hasCompletedCourse(String courseId);
    public int getCourseGPA(String courseId);
    public void saveCourse(String courseId, List<Question> questions);
}
