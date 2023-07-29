package usecases.LoginStudentUseCase;

import frameworksdriversmock.DatabaseDriverMock;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginStudentPresenter;
import interfaceadapters.LoginStudentInterfaceAdapters.LoginUserFailed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the loginStudent interactor. This tests whether a student is able to log in successfully, if they
 * have a username that exists, and the correct password.
 */
class LoginStudentInteractorTest {
    private LoginStudentInteractor loginInteractor;

    /**
     * Initializes the interactor before each test such that we can reuse it.
     */
    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        LoginStudentPresenter loginPresenter = new LoginStudentPresenter(databaseDriver);

        loginInteractor = new LoginStudentInteractor(databaseDriver.getStudentDbGatewayMock(), databaseDriver.getSessionDbGatewayMock(), loginPresenter);
    }

    /**
     * Test empty usernames throw an exception with Empty usernames invalid messsage.
     */
    @Test
    public void testEmptyUsername() {
        String username = "";
        String password = "abc";
        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username, password);

        // Empty usernames should throw a LoginUserFailed Exception
        try {
            loginInteractor.login(requestModel);
            Assertions.fail("This should not happen.");
        } catch (LoginUserFailed e) {
            Assertions.assertEquals(e.getMessage(), "Empty username is invalid.");
        }
    }

    /**
     * Test usernames that don't exist throw an Exception with Username doesn't exist message.
     */
    @Test
    public void testUsernameNotExist() {
        String username = "jpmg";
        String password = "abc";
        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username, password);

        // Usernames that don't exist should throw a LoginUserFailed Exception
        try {
            loginInteractor.login(requestModel);
            Assertions.fail("This should not happen.");
        } catch (LoginUserFailed e) {
            Assertions.assertEquals(e.getMessage(), "Username does not exist.");
        }
    }

    /**
     * Test empty passwords must throw an exception with a Password incorrect message.
     */
    @Test
    public void testEmptyPassword() {
        String username = "jpmedina";
        String password = "";
        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username, password);

        // Empty passwords should throw a LoginUserFailed Exception
        try {
            loginInteractor.login(requestModel);
            Assertions.fail("This should not happen.");
        } catch (LoginUserFailed e) {
            Assertions.assertEquals(e.getMessage(), "Password is incorrect");
        }
    }

    /**
     * Test usernames that exist in database but wrong passwords throw an Exception with a Password incorrect message.
     */
    @Test
    public void testRightUsernameWrongPassword() {
        String username = "jpmedina";
        String password = "jpp";
        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username, password);

        // Wrong passwords should throw a LoginUserFailed Exception
        try {
            loginInteractor.login(requestModel);
            Assertions.fail("This should not happen.");
        } catch (LoginUserFailed e) {
            Assertions.assertEquals(e.getMessage(), "Password is incorrect");
        }
    }

    /**
     * Test that the response model returns the username if the username and password are correct.
     */
    @Test
    public void testRightUsernamePassword() {
        String username = "jpmedina";
        String password = "gmpj";
        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username, password);

        LoginStudentResponseModel responseModel = loginInteractor.login(requestModel);
        Assertions.assertEquals(responseModel.getUsername(), requestModel.getUsername());
    }

    /**
     * Test that other users that exist in database are able to log in.
     */
    @Test
    public void testMoreCorrectUsernamePassword() {
        String username = "adelina";
        String password = "anileda";
        LoginStudentRequestModel requestModel = new LoginStudentRequestModel(username, password);

        LoginStudentResponseModel responseModel = loginInteractor.login(requestModel);
        Assertions.assertEquals(responseModel.getUsername(), requestModel.getUsername());
    }

}