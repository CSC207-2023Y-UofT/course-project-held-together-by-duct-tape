package courseenrolmentusecase;


public interface EnrolmentDataAccess {
    public boolean hasCompletedCourse(String studentId, String courseId);
    public int getCourseGPA(String studentId, String courseId);
    public void saveCourse(String studentId, String courseId);
}
