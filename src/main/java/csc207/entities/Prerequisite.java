package csc207.entities;

import java.util.Objects;

/**
 * A prerequisite that is required for a student to complete before being
 * able to enroll in a course.
 */
public class Prerequisite {
    private final String course;
    private final int gpa;

    /**
     * Construct a prerequisite with the course id given and gpa.
     *
     * @param course the course prerequisite.
     * @param gpa the gpa associated with the course required.
     */
    public Prerequisite(String course, int gpa) {
        this.course = course;
        this.gpa = gpa;
    }

    public boolean isEmpty() {
        return Objects.equals(this.course, "");
    }

    public String getCourse() {
        return this.course;
    }

    public int getGpa() {
        return this.gpa;
    }
}
