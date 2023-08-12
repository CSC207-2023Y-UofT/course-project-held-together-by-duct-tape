package interfaceAdapters.courseEvaluatorInterfaceAdapters;

import frameworksDriversMock.DatabaseDriverMock;
import useCases.courseEvaluatorUseCase.EvaluatorInteractor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the course evaluator controller. This tests the creation of a request model and the call made
 * to the interactor.
 */
public class EvaluatorControllerTest {

    private EvaluatorController evaluatorController;

    /**
     * Initializes the controller before each test.
     */

    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        EvaluatorPresenter evaluatorPresenter = new EvaluatorPresenter(databaseDriver);
        EvaluatorInteractor evaluatorInteractor = new EvaluatorInteractor(evaluatorPresenter, databaseDriver.getCourseDbGatewayMock(),
                databaseDriver.getSessionDbGatewayMock(), databaseDriver.getStudentDbGatewayMock());

        this.evaluatorController = new EvaluatorController(evaluatorInteractor);

    }

    @Test
    public void testRequestModelCreation() {
        Assertions.assertEquals(evaluatorController.evaluateCourse(), "You got " + 100.0f + "% in CSC108");
    }
}



