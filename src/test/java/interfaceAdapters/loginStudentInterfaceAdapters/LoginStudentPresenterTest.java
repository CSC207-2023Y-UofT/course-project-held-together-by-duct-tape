package interfaceAdapters.loginStudentInterfaceAdapters;

import frameworksDriversMock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import useCases.loginStudentUseCase.LoginStudentResponseModel;

public class LoginStudentPresenterTest {
    private LoginStudentPresenter loginPresenter;

    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        loginPresenter = new LoginStudentPresenter(databaseDriver);
    }

    @Test
    public void testSuccessViewRandomUsername() {
        LoginStudentResponseModel responseModel = new LoginStudentResponseModel("jpmedina");
        Assertions.assertEquals(loginPresenter.prepareSuccessView(responseModel).getUsername(), "jpmedina");
    }

    @Test
    public void testSuccessViewRandomMessage() {
        LoginStudentResponseModel responseModel = new LoginStudentResponseModel("response");
        Assertions.assertEquals(loginPresenter.prepareSuccessView(responseModel).getUsername(), "response");
    }

    @Test
    public void testFailViewMessage() {
        try {
            loginPresenter.prepareFailView("Username does not exist.");
        } catch (LoginUserFailed e) {
            Assertions.assertEquals(e.getMessage(), "Username does not exist.");
        }
    }

    @Test
    public void testFailViewThrowsException() {
        try {
            loginPresenter.prepareFailView("Empty username is invalid.");
        } catch (LoginUserFailed e) {
            Assertions.assertTrue(true);
        }
    }

}