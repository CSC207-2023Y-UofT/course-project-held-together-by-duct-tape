package courseEvaluator.UseCases;

import entities.Course;


public class EvaluatorInteractor implements EvaluatorInputBoundary {
   private EvaluatorOutputBoundary presenter;
   private StudentDataAccess courseDbGateway;

   private EvaluatorSessionDataAccess DataAccess;

   public EvaluatorInteractor(EvaluatorOutputBoundary presenter, StudentDataAccess courseDbGateway, EvaluatorSessionDataAccess dataAccess) {
        this.presenter = presenter;
        this.courseDbGateway = courseDbGateway;
        this.DataAccess = dataAccess;
    }
   // -checks if it is a valid course (correct answers must not be empty)


    public EvaluatorResponseModel callToRetrieveCourse(EvaluatorRequestModel requestModel) {
        EvaluatorDbRequestModel dbRequestModel = new EvaluatorDbRequestModel(requestModel.getCourseId());
        return DataAccess.retrieveCourse(dbRequestModel.getCourseId());
    }


    public EvaluatorResponseModel evaluate(EvaluatorRequestModel requestModel) {

        if (!DataAccess.CourseExists(requestModel.getCourseId())) {
            return presenter.prepareFailView("Course does not exist in Database!");
        }
        EvaluatorResponseModel ResponseModel = callToRetrieveCourse(requestModel);

        EvaluatorResponseModel EvaluatorResponseModel = new EvaluatorResponseModel(ResponseModel.getCourseId(),
                ResponseModel.getGrade());

        new SaveCourse(requestModel.getStudentId(), requestModel.getCourseId(), requestModel.getGrade());
        return presenter.prepareSuccessView(EvaluatorResponseModel);
    }
}
