package usecases.CourseEnrollmentUseCase;


import entities.Question;

import java.util.List;

public interface EnrolmentDataAccess {
    public boolean hasCompletedCourse(String studentId, String courseId);
    public int getCourseGPA(String studentId, String courseId);
    public void saveCourse(String studentId, List<Question> questions);
}
