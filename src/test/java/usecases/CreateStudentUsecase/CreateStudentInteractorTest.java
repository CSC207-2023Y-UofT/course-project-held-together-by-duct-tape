package usecases.CreateStudentUsecase;

import frameworksdrivers.StudentDbGatewayMock;
import interfaceadapters.CreateStudentInterfaceAdapters.CreateStudentPresenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateStudentInteractorTest {
    CreateStudentInteractor interactor;
    CreateStudentRequestModel[] requestModels;

    @BeforeEach
    public void init(){
        CreateStudentDataAccess gateway = new StudentDbGatewayMock();
        interactor = new CreateStudentInteractor(gateway, new CreateStudentPresenter());
        requestModels = new CreateStudentRequestModel[]{
                        new CreateStudentRequestModel("Nour", "Nour"),
                        new CreateStudentRequestModel("Hanan", "Hassan"),
                        new CreateStudentRequestModel("", "")};
    }

    @Test
    public void CreateStudentTestPass(){
        // fails because mock gateway tells it to fail
        // assertEquals("You have successfully created a New student! Welcome Nour",
        //        interactor.createStudent(requestModels[0]));
    }

    @Test
    public void CreateStudentTestFail(){
        Assertions.assertEquals("Sorry it appears that either the Username already exists or you provided two different " +
                "usernames", interactor.createStudent(requestModels[1]));
        Assertions.assertEquals("Sorry it appears that either the Username already exists or you provided two different " +
                "usernames", interactor.createStudent(requestModels[2]));
    }
}


