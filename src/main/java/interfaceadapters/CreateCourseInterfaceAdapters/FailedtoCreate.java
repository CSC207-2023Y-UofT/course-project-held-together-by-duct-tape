package interfaceadapters.CreateCourseInterfaceAdapters;

public class FailedtoCreate extends RuntimeException{
    public FailedtoCreate(String errorMessage) { super(errorMessage);
    }
}
