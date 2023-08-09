package entities;

import entities.courseBuilder.CourseBuilder;

/**
 * CourseFactory that acts as a Director in the Builder Design Pattern. This director has a method called create which
 * creates a Course according to the CourseBuilder interface. It builds the questions and the prerequisites. Different
 * builders implement the build methods differently.
 */
public class CourseFactory {
    private CourseBuilder builder;

    public CourseFactory(CourseBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(CourseBuilder newBuilder) {
        this.builder = newBuilder;
    }

    public void create() {
        builder.buildQuestions();
        builder.buildPrerequisite();
    }
}


