package interfaceadapters.CreateStudentInterfaceAdapters;
import frameworksdriversmock.DatabaseDriverMock;
import org.junit.jupiter.api.Test;
import usecases.CreateStudentUsecase.CreateStudentResponseModel;
import static org.junit.jupiter.api.Assertions.*;

class CreateStudentPresenterTest {

    @Test
    void getSuccessMessage() {
        CreateStudentPresenter presenter = new CreateStudentPresenter(new DatabaseDriverMock());
        assertEquals("You have successfully created a New student! Welcome Nour",
                presenter.getSuccessMessage(new CreateStudentResponseModel("Nour")));
    }

    @Test
    void getFailMessage() { CreateStudentPresenter presenter = new CreateStudentPresenter(new DatabaseDriverMock());
        assertEquals("Sorry it appears that either the Username already exists, or your passwords don't match!",
                presenter.getFailMessage());
    }
}