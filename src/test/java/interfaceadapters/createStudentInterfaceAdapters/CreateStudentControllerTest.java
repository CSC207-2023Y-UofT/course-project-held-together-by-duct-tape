package interfaceadapters.createStudentInterfaceAdapters;
import frameworksdriversmock.CourseDbGatewayMock;
import frameworksdriversmock.DatabaseDriverMock;
import frameworksdriversmock.StudentDbGatewayMock;
import org.junit.jupiter.api.Test;
import usecases.createStudentUsecase.CreateStudentInteractor;
import static org.junit.jupiter.api.Assertions.*;

class CreateStudentControllerTest {

    @Test
    public void TestCreateSuccess(){
        CreateStudentPresenter presenter = new CreateStudentPresenter(new DatabaseDriverMock());
        CreateStudentInteractor interactor =
                new CreateStudentInteractor(new StudentDbGatewayMock(),presenter, new CourseDbGatewayMock());
        CreateStudentController controller = new CreateStudentController(interactor);
        assertEquals("You have successfully created a New student! Welcome Nour",
                controller.create("Nour", "1234", "1234"));
    }

    @Test
    public void TestCreateFail(){
        CreateStudentPresenter presenter = new CreateStudentPresenter(new DatabaseDriverMock());
        CreateStudentInteractor interactor =
                new CreateStudentInteractor(new StudentDbGatewayMock(),presenter, new CourseDbGatewayMock());
        CreateStudentController controller = new CreateStudentController(interactor);
        String passwordMismatch = controller.create("Nour", "123", "1234");
        String usernameExists = controller.create("nourh", "1234", "1234");
        String both = controller.create("nourh", "123", "1234");
        assertEquals("Sorry it appears that either the Username already exists, or your passwords don't match!",
                passwordMismatch);
        assertEquals("Sorry it appears that either the Username already exists, or your passwords don't match!",
                both);
        assertEquals("Sorry it appears that either the Username already exists, or your passwords don't match!",
                usernameExists);
    }

}