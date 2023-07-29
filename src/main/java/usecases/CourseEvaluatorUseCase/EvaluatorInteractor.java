package usecases.CourseEvaluatorUseCase;

public class EvaluatorInteractor implements EvaluatorInputBoundary {
   private final EvaluatorOutputBoundary presenter;
   private final EvaluatorStudentDataAccess studentDataAccess;
   private final EvaluatorCourseDataAccess courseDbGateway;
   private final EvaluatorSessionDataAccess sessionDataAccess;

   public EvaluatorInteractor(EvaluatorOutputBoundary presenter, EvaluatorCourseDataAccess courseDbGateway,
                              EvaluatorSessionDataAccess sessionDataAccess,
                              EvaluatorStudentDataAccess studentDataAccess) {
       this.presenter = presenter;
       this.courseDbGateway = courseDbGateway;
       this.sessionDataAccess = sessionDataAccess;
       this.studentDataAccess = studentDataAccess;
   }

    /**
    * Use case for saving and evaluating  a students grade in percentages. If the course
    * does not exist, an error is thrown, that informs students that the course does not exist.
    * if course exists in database
    * the student grade is saved to the Student data access.
    * Then the presenter prepares success/fail views depending on each case.
    *
    * @return String prepare success and fail view.
    */
    public String evaluate() {
        // Retrieves course answered by the student
        EvaluatorDbResponseModel studentResponseModel = sessionDataAccess.retrieveCourse();

        String courseID = studentResponseModel.getCourseId();
        String studentID = sessionDataAccess.retrieveStudentId();

        // Retrieves original course created
        EvaluatorDbResponseModel courseResponseModel = new EvaluatorDbResponseModel(studentResponseModel.getCourseId());
        courseDbGateway.findCourse(courseResponseModel);

        // calls compare from check answer to get a percentage
        float percentage =  CheckAnswer.compare(studentResponseModel, courseResponseModel);

        // saves gpa in student data access
        EvaluatorDbRequestModel requestModel = new EvaluatorDbRequestModel(studentID, courseID, percentage);
        studentDataAccess.saveGPA(requestModel);

        //prepares response model to return
        EvaluatorResponseModel EvaluatorResponseModel = new EvaluatorResponseModel(studentResponseModel.getCourseId(), percentage);
        return presenter.prepareSuccessView(EvaluatorResponseModel);
    }
}
