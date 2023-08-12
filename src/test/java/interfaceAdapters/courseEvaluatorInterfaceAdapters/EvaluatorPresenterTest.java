package interfaceAdapters.courseEvaluatorInterfaceAdapters;

import frameworksDriversMock.DatabaseDriverMock;
import useCases.courseEvaluatorUseCase.EvaluatorResponseModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EvaluatorPresenterTest {
    private final DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
    private EvaluatorPresenter evaluatorPresenter;

    @BeforeEach
    public void init() {
        this.evaluatorPresenter = new EvaluatorPresenter(databaseDriver);
    }

    @Test
    public void testSuccessView() {
        EvaluatorResponseModel responseModel = new EvaluatorResponseModel("CSC108", 100.0f);
        Assertions.assertEquals(evaluatorPresenter.prepareSuccessView(responseModel),
                "You got " + 100.0f + "% in CSC108");
    }
}

