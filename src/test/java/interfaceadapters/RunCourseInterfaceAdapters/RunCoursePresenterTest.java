package interfaceadapters.RunCourseInterfaceAdapters;

import frameworksdriversmock.DatabaseDriverMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunCoursePresenterTest {
    private RunCoursePresenter runCoursePresenter;

    @BeforeEach
    public void init() {
        DatabaseDriverMock databaseDriver = new DatabaseDriverMock();
        runCoursePresenter = new RunCoursePresenter(databaseDriver);
    }
    @Test
    public void testPresenterSuccessView(){
        String message = "message";
        Assertions.assertEquals(runCoursePresenter.successView(message), message);
    }
    @Test
    public void testPresenterFailView(){
        String message = "message";
        Assertions.assertEquals(runCoursePresenter.failView(message), message);
    }
}
