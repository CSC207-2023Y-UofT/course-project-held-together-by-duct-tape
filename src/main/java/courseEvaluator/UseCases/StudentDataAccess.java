package courseEvaluator.UseCases;

import courseEvaluator.UseCases.EvaluatorDbRequestModel;

public interface StudentDataAccess {

    int saveGPA (EvaluatorDbRequestModel requestModel);
}
