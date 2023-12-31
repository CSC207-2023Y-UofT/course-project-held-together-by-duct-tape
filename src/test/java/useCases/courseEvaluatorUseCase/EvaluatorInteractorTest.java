package useCases.courseEvaluatorUseCase;

import frameworksDriversMock.DatabaseDriverMock;
import interfaceAdapters.courseEvaluatorInterfaceAdapters.EvaluatorPresenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvaluatorInteractorTest {
    private EvaluatorInteractor interactor;

    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        EvaluatorPresenter coursePresenter = new EvaluatorPresenter(databaseDriver);
        interactor = new EvaluatorInteractor(coursePresenter, databaseDriver.getCourseDbGatewayMock(),
                databaseDriver.getSessionDbGatewayMock(), databaseDriver.getStudentDbGatewayMock());

    }
    @Test
    public void retrievedCourse() {
        Assertions.assertEquals(interactor.evaluate(), "You got " + 100.0f + "% in CSC108");
    }

}

