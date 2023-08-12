package interfaceAdapters.createCourseInterfaceAdapters;


/**
 * Exception raised when there is an error in creating courses.
 */
public class FailedtoCreate extends RuntimeException{
    public FailedtoCreate(String errorMessage) { super(errorMessage);
    }
}
