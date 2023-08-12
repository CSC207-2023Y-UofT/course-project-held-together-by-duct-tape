package useCases.runCourseUseCase;

public interface RunCourseOutputBoundary {
    String failView(String message);
    String successView(String message);
}
