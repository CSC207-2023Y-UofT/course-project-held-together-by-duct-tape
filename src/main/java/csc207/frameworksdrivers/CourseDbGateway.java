package csc207.frameworksdrivers;

import csc207.courseenrolmentusecase.EnrolmentCourseDataAccess;
import csc207.courseenrolmentusecase.EnrolmentDbResponseModel;
import csc207.entities.Prerequisite;

import java.util.ArrayList;

public class CourseDbGateway implements EnrolmentCourseDataAccess {
    @Override
    public boolean existsByCourseId(String courseId) {
        return true;
    }

    @Override
    public EnrolmentDbResponseModel retrieveCourse(String courseId) {
        return new EnrolmentDbResponseModel(courseId, new ArrayList<>(),
                new Prerequisite("CSC108", 50));
    }
}
