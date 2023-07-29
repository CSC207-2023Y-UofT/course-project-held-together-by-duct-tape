package usecases.CourseEvaluator;


import entities.Course;
import entities.CourseFactory;

public class EvaluatorInteractor implements EvaluatorInputBoundary {
   private EvaluatorOutputBoundary presenter;
   private StudentDataAccess studentDataAccess;

   private CourseDataAccess courseDbGateway;

   private EvaluatorSessionDataAccess sessionDataAccess;

   private CourseFactory courseFactory;

   private CheckAnswer grade;


   public EvaluatorInteractor(EvaluatorOutputBoundary presenter, CourseDataAccess courseDbGateway,
                              EvaluatorSessionDataAccess sessionDataAccess, CourseFactory courseFactory,
                              StudentDataAccess studentDataAccess, CheckAnswer grade) {
        this.presenter = presenter;
        this.courseDbGateway = courseDbGateway;
        this.sessionDataAccess = sessionDataAccess;
        this.courseFactory = courseFactory;
        this.studentDataAccess = studentDataAccess;
        this.grade = grade;
    }

    /**
     * Use case for saving and evaluating  a students grade in percentages. If the course
     * does not exist, an error is thrown, that informs students that the course does not exist.
     * if course exists in database
     * the student grade is saved to the Student data access.
     * Then the presenter prepares success/fail views depending on each case.
     *
     * @param requestModel data structure packaging the courseId.
     * @return String prepare success and fail view.
     */


    public String evaluate(EvaluatorRequestModel requestModel) {

        // creates response model for student and course and creates a course for each of them as well

        EvaluatorDbResponseModel studentResponseModel = sessionDataAccess.retrieveCourse(requestModel);

        EvaluatorDbResponseModel courseResponseModel = courseDbGateway.findCourse(requestModel);

        Course studentsCourse = courseFactory.create(studentResponseModel.getCourseId(), studentResponseModel.getQuestions(),
                studentResponseModel.getAnswers(), studentResponseModel.getPoints());

        Course originalCourse = courseFactory.create(courseResponseModel.getCourseId(), courseResponseModel.getQuestions(),
               courseResponseModel.getAnswers(), courseResponseModel.getPoints());

        // calls compare from check answer to get a percentage

        int percentage =  grade.compare(studentsCourse, originalCourse);

        // saves gpa in student data access

        studentDataAccess.saveGPA(new EvaluatorDbRequestModel(sessionDataAccess.retrieveStudentId(),
                requestModel.getCourseId(), percentage));

        //prepares response model to return

        EvaluatorResponseModel EvaluatorResponseModel = new EvaluatorResponseModel(studentResponseModel.getCourseId(),
                percentage);


        return presenter.prepareSuccessView(EvaluatorResponseModel);
    }
}
