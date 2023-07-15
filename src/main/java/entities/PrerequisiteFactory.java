package entities;

/**
 * Factory for creating new Prerequisites.
 */
public class PrerequisiteFactory {

    /**
     * Builds a new Prerequisite with the default grade.
     * @param coursePreReq the course prerequisite.
     * @return Prerequisite object.
     */
    public static Prerequisite create(String coursePreReq) {
        return new Prerequisite(coursePreReq);
    }

    /**
     * Builds a new Prerequisite with the grade required.
     * @param coursePreReq the course prerequisite.
     * @param grade the grade required.
     * @return Prerequisite object.
     */
    public static Prerequisite create(String coursePreReq, int grade) {
        return new Prerequisite(coursePreReq, grade);
    }
}
