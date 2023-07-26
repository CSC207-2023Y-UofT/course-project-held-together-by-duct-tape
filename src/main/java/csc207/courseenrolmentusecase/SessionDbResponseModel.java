package csc207.courseenrolmentusecase;

public class SessionDbResponseModel {

    private String courseId;
    private int courseGrade;

    public SessionDbResponseModel(String prerequisiteId, int prerequisiteGrade) {
        this.courseId = prerequisiteId;
        this.courseGrade = prerequisiteGrade;
    }

    public String getPrerequisiteId() {
        return courseId;
    }

    public int getPrerequisiteGrade() {
        return courseGrade;
    }
}
