package usecases.CourseEvaluator;


import entities.Course;
import entities.CourseFactory;

public class EvaluatorInteractor implements EvaluatorInputBoundary {
   private EvaluatorOutputBoundary presenter;
   private StudentDataAccess studentDataAccess;

   private CourseDataAccess courseDbGateway;

   private EvaluatorSessionDataAccess DataAccess;

   private CourseFactory courseFactory;

   private CheckAnswer grade;



   public EvaluatorInteractor(EvaluatorOutputBoundary presenter, CourseDataAccess courseDbGateway,
                              EvaluatorSessionDataAccess dataAccess, CourseFactory courseFactory,
                              StudentDataAccess studentDataAccess, CheckAnswer grade) {
        this.presenter = presenter;
        this.courseDbGateway = courseDbGateway;
        this.DataAccess = dataAccess;
        this.courseFactory = courseFactory;
        this.studentDataAccess = studentDataAccess;
        this.grade = grade;
    }
   // -checks if it is a valid course (correct answers must not be empty)




    public String evaluate(EvaluatorRequestModel requestModel) {

        if (!DataAccess.CourseExists(requestModel.getCourseId())) {
            return presenter.prepareFailView();
        }
        EvaluatorDbResponseModel ResponseModel = DataAccess.retrieveCourse(requestModel.getCourseId());


        Course studentsCourse = courseFactory.create(ResponseModel.getCourseId(), ResponseModel.getQuestions(),
                ResponseModel.getAnswers(), ResponseModel.getPoints()); // no get course in factory

        EvaluatorDbResponseModel ogCourse = courseDbGateway.findCourse(requestModel.getCourseId());

        Course orginalCourse = courseFactory.create(ogCourse.getCourseId(), ogCourse.getQuestions(),
               ogCourse.getAnswers(), ogCourse.getPoints());

       int percentage =  grade.compare(studentsCourse, orginalCourse);

        EvaluatorResponseModel EvaluatorResponseModel = new EvaluatorResponseModel(ResponseModel.getCourseId(),
                percentage);

        studentDataAccess.saveGPA(new EvaluatorDbRequestModel(DataAccess.retrieveStudentId(), requestModel.getCourseId()
                , percentage));

        return presenter.prepareSuccessView(EvaluatorResponseModel);
    }
}
