package entities.courseBuilder;

import entities.Course;

/**
 * Builder interface which has three methods. Build questions builds the questions of the course. Build prerequisite
 * builds the prerequisite of the course. Get product returns the course object.
 */
public interface CourseBuilder {
    void buildQuestions();
    void buildPrerequisite();
    Course getProduct();
}
