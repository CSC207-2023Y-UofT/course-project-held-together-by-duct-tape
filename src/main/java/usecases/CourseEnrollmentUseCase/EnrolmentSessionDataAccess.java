package usecases.CourseEnrollmentUseCase;


import entities.Question;

import java.util.List;

public interface EnrolmentSessionDataAccess {
    public boolean hasCompletedCourse(EnrolmentDbRequestModel requestModel);
    public int getPrerequisiteCourseGPA(EnrolmentDbRequestModel requestModel);
    public void saveCourse(EnrolmentDbRequestModel requestModel);
    public void deleteCourseSession();
}
