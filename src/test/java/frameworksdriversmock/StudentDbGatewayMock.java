package frameworksdriversmock;

import frameworksdrivers.StudentGateway;

import usecases.CourseEvaluatorUseCase.EvaluatorDbRequestModel;
import usecases.CreateStudentUsecase.CreateStudentDsModel;
import usecases.LoginStudentUseCase.LoginStudentDbRequestModel;
import usecases.LoginStudentUseCase.LoginStudentRequestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDbGatewayMock implements StudentGateway {
    private final List<String> studentIDs = new ArrayList<>();
    private final List<String> passwords = new ArrayList<>();
    private final List<Map<String, Integer>> courses = new ArrayList<>();

    public StudentDbGatewayMock() {
        Map<String, Integer> courses1 = new HashMap<>();
        courses1.put("CSC108", 95);
        courses1.put("CSC207", 90);
        addStudent("jpmedina", "gmpj", courses1);

        Map<String, Integer> courses2 = new HashMap<>();
        courses2.put("CSC108", 99);
        addStudent("nourh", "hn", courses2);

        Map<String, Integer> courses3 = new HashMap<>();
        courses3.put("CSC108", 99);
        addStudent("adelina", "anileda", courses3);
    }

    private void addStudent(String studentID, String password, Map<String, Integer> studentCourses) {
        studentIDs.add(studentID);
        passwords.add(password);
        courses.add(studentCourses);
    }

    @Override
    public boolean usernameExists(String username) {
        return studentIDs.contains(username);
    }

    @Override
    public void saveUser(CreateStudentDsModel student) {}

    @Override
    public void getUser(LoginStudentDbRequestModel dbRequestModel) {
        int studentIndex = studentIDs.indexOf(dbRequestModel.getUsername());
        dbRequestModel.setCourses(courses.get(studentIndex));
    }

    @Override
    public boolean checkPassword(LoginStudentRequestModel requestModel) {
        int studentIndex = studentIDs.indexOf(requestModel.getUsername());
        return passwords.get(studentIndex).equals(requestModel.getPassword());
    }

    @Override
    public int saveGPA(EvaluatorDbRequestModel requestModel) {
        return 0;
    }
}
