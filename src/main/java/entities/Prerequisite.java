package entities;

public class Prerequisite {

    private final String course;
    private final int gpa;

    public Prerequisite(String course, int gpa) {
        this.course = course;
        this.gpa = gpa;
    }

    public String getCourse() {
        return this.course;
    }

    public int getGpa() {
        return this.gpa;
    }
}
