package csc207.entities;
import java.util.List;
import java.util.ArrayList;

/**
 * Factory for creating Courses.
 */
public class CourseFactory {

    /**
     * Builds a new Course from course id, course prerequisite with grade, as well as three
     * lists of questions, answers, and points. For each list, the ith element are
     * related as the ith question, ith answer, and ith points for that question.
     *
     * @param courseId the unique course id.
     * @param coursePreReq the course code prerequisite.
     * @param questions list of questions associated with this course.
     * @param answers list of answers associated with each question.
     * @param points list of points associated with each question.
     * @return Course object
     */
    public static Course create(String courseId, String coursePreReq, int coursePreReqGrade,
                         List<String> questions, List<String> answers, List<Integer> points) {
        // Builds the list of Questions
        List<Question> courseQuestions = new ArrayList<Question>();
        for (int j = 0; j < questions.size(); j++){
            courseQuestions.add(QuestionFactory.create(questions.get(j), answers.get(j), points.get(j)));
        }

        Prerequisite preReq = PrerequisiteFactory.create(coursePreReq, coursePreReqGrade);

        return new Course(courseId, preReq, courseQuestions);
    }

    /**
     * Builds a new Course from course id, course prerequisite, as well as three
     * lists of questions, answers, and points. For each list, the ith element are
     * related as the ith question, ith answer, and ith points for that question. The
     * default grade prerequisite is 50, so students must receive a grade of at least
     * 50 in the course prerequisite.
     *
     * @param courseId the unique course id.
     * @param coursePreReq the course code prerequisite.
     * @param questions list of questions associated with this course.
     * @param answers list of answers associated with each question.
     * @param points list of points associated with each question.
     * @return Course object
     */
    public static Course create(String courseId, String coursePreReq, List<String> questions,
                         List<String> answers, List<Integer> points) {
        return CourseFactory.create(courseId, coursePreReq, 50, questions, answers, points);
    }

    /**
     * Builds a new Course from course id, as well as three lists of questions, answers,
     * and points. For each list, the ith element are related as the ith question, ith
     * answer, and ith points for that question. This course has no prerequisite, thus it is
     * an empty string with 0 course grade to signify an empty prerequisite.
     *
     * @param courseId the unique course id.
     * @param questions list of questions associated with this course.
     * @param answers list of answers associated with each question.
     * @param points list of points associated with each question.
     * @return Course object
     */
    public static Course create(String courseId, List<String> questions, List<String> answers, List<Integer> points) {
        return CourseFactory.create(courseId, "", 0, questions, answers, points);
    }
}


