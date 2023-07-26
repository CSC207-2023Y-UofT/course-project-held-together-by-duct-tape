package usecases.CreateStudentUsecase;

import static org.junit.jupiter.api.Assertions.*;

import frameworksdrivers.StudentDbGateway;
import interfaceadapters.CreateStudent.CreateStudentPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateStudentInteractorTest {
    CreateStudentInteractor interactor;
    CreateStudentRequestModel[] requestModels;

    @BeforeEach
    public void init(){
        interactor = new CreateStudentInteractor(new StudentDbGateway(), new CreateStudentPresenter());
        requestModels = new CreateStudentRequestModel[]{new CreateStudentRequestModel("Nour", "Nour"),
                        new CreateStudentRequestModel("Hanan", "Hassan"),
                        new CreateStudentRequestModel("", "")};}
    @Test
    public void CreateStudentTestPass(){
        assertEquals("You have successfully created a New student! Welcome Nour",
                interactor.createStudent(requestModels[0]));}
    @Test
    public void CreateStudentTestFail(){
        assertEquals("Sorry it appears that either the Username already exists or you provided two different " +
                "usernames", interactor.createStudent(requestModels[1]));
        assertEquals("Sorry it appears that either the Username already exists or you provided two different " +
                "usernames", interactor.createStudent(requestModels[2]));}
}


