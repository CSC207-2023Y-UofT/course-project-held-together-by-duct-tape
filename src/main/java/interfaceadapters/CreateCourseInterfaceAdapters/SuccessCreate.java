package interfaceadapters.CreateCourseInterfaceAdapters;

/**
 * Exception raised when user successfully created courses.
 */
public class SuccessCreate extends RuntimeException{
    public SuccessCreate(String s) { super(s);
    }
}
