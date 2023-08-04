package interfaceadapters.LoginStudentInterfaceAdapters;

import frameworksdriversmock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.LoginStudentUseCase.LoginStudentInputBoundary;
import usecases.LoginStudentUseCase.LoginStudentInteractor;

public class LoginStudentControllerTest {
    private LoginStudentController loginController;

    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        LoginStudentPresenter loginPresenter = new LoginStudentPresenter(databaseDriver);
        LoginStudentInputBoundary loginInteractor = new LoginStudentInteractor(databaseDriver.getStudentDbGatewayMock(), databaseDriver.getSessionDbGatewayMock(), loginPresenter);

        this.loginController = new LoginStudentController(loginInteractor);
    }

    @Test
    public void testControllerEmptyUsername() {
        try {
            loginController.login("", "jp");
            Assertions.fail("This should not happen.");
        } catch (LoginUserFailed e) {
            Assertions.assertEquals(e.getMessage(), "Empty username is invalid.");
        }
    }

    @Test
    public void testControllerUsernameNotExist() {
        try {
            loginController.login("jpmg", "gmpj");
            Assertions.fail("This should not happen.");
        } catch (LoginUserFailed e) {
            Assertions.assertEquals(e.getMessage(), "Username does not exist.");
        }
    }

    @Test
    public void testControllerRightUsernameWrongPassword() {
        try {
            loginController.login("jpmedina", "jpmg");
            Assertions.fail("This should not happen.");
        } catch (LoginUserFailed e) {
            Assertions.assertEquals(e.getMessage(), "Password is incorrect");
        }
    }

    @Test
    public void testControllerRightUsernamePassword() {
        Assertions.assertEquals(loginController.login("jpmedina", "gmpj").getUsername(), "jpmedina");
    }
}