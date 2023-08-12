package interfaceAdapters.courseEnrollmentInterfaceAdapters;

/**
 * Exception raised when there is an error in logging in a student.
 */
public class EnrolmentFailure extends RuntimeException {

    public EnrolmentFailure(String error) {
        super(error);
    }
}
