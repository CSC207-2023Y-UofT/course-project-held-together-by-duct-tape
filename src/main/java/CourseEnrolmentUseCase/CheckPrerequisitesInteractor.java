package UseCases;

import entities.Course;
import entities.CourseModified;
import entities.Prerequisite;
import entities.Student;

public class CheckPrerequisitesInteractor {
    private Student student;
    private Prerequisite prerequisite;
    private EnrolmentDbResponseModel course;
    //private CourseModified courseM;
    public boolean checkPrerequisite(EnrolmentDbResponseModel course) { //if one prerequisite
        return student.getCourses().containsKey(prerequisite.getCourse()) &&
                student.getCourses().get(prerequisite.getCourse()) >= course.getCourse().getPrerequisite().getGpa();
    }
    /*public boolean checkPrerequisites(EnrolmentDbResponseModel courseM) { //if multiple prerequisites for a course
        for (Prerequisite p : courseM.getPrerequisites()) {
            if (!(student.getCourses().containsKey(p.getCourse()) &&
                    student.getCourses().get(p.getCourse()) >= p.getGpa())) {
                return false;
            }
        }
        return true;
    }*/
}
