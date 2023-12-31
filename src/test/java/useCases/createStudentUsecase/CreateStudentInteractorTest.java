package useCases.createStudentUsecase;

import frameworksDriversMock.CourseDbGatewayMock;
import frameworksDriversMock.DatabaseDriverMock;
import frameworksDriversMock.StudentDbGatewayMock;
import interfaceAdapters.createStudentInterfaceAdapters.CreateStudentPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CreateStudentInteractorTest {
    CreateStudentInteractor interactor;
    CreateStudentRequestModel[] requestModels;

    @BeforeEach
    public void init(){
       CreateStudentDataAccess gateway = new StudentDbGatewayMock();
       CreateStudentCourseDataAccess gateway2 = new CourseDbGatewayMock();
       CreateStudentPresenter presenter = new CreateStudentPresenter(new DatabaseDriverMock());
       interactor =
               new CreateStudentInteractor(gateway, presenter, gateway2);
       requestModels = new CreateStudentRequestModel[]{
                       new CreateStudentRequestModel("Nour", "1234", "1234"),
                        new CreateStudentRequestModel("Hanan", "123", "1234"),
                        new CreateStudentRequestModel("", "", ""),
                        new CreateStudentRequestModel("nourh", "123", "123")};
    }

    @Test
    public void CreateStudentTestPass(){
        // fails because mock gateway tells it to fail
        assertEquals("You have successfully created a New student! Welcome Nour",
                interactor.createStudent(requestModels[0]));
    }

    @Test
    public void CreateStudentTestFail(){
        Assertions.assertEquals("Sorry it appears that either the Username already exists, " +
                "or your passwords don't match!", interactor.createStudent(requestModels[1]));
        Assertions.assertEquals("Sorry it appears that either the Username already exists, " +
                "or your passwords don't match!", interactor.createStudent(requestModels[2]));
        Assertions.assertEquals("Sorry it appears that either the Username already exists, " +
                "or your passwords don't match!", interactor.createStudent(requestModels[3]));
        // username already exists
    }
}


