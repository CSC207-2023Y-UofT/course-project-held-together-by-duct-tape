package frameworksdriversmock;

import frameworksdrivers.gateways.StudentGateway;

import usecases.courseEvaluatorUseCase.EvaluatorDbRequestModel;
import usecases.createStudentUsecase.CreateStudentDataAccess;
import usecases.createStudentUsecase.CreateStudentDsModel;
import usecases.loginStudentUseCase.LoginStudentDbRequestModel;
import usecases.loginStudentUseCase.LoginStudentRequestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mock Student Gateway that acts as the gateway in the program. Has attributes of what would be in the actual
 * database so that we can run tests on this gateway. It holds studentIDs, passwords, and the course mappings.
 */
public class StudentDbGatewayMock implements StudentGateway, CreateStudentDataAccess {
    private final List<String> studentIDs = new ArrayList<>();
    private final List<String> passwords = new ArrayList<>();
    private final List<Map<String, Float>> courses = new ArrayList<>();

    public StudentDbGatewayMock() {
        Map<String, Float> courses1 = new HashMap<>();
        courses1.put("CSC108", 95f);
        courses1.put("CSC207", 90f);
        addStudent("jpmedina", "gmpj", courses1);

        Map<String, Float> courses2 = new HashMap<>();
        courses2.put("CSC108", 99f);
        addStudent("nourh", "hn", courses2);

        Map<String, Float> courses3 = new HashMap<>();
        courses3.put("CSC108", 99f);
        addStudent("adelina", "anileda", courses3);
    }

    private void addStudent(String studentID, String password, Map<String, Float> studentCourses) {
        studentIDs.add(studentID);
        passwords.add(password);
        courses.add(studentCourses);
    }

    @Override
    public boolean usernameExists(String username) {
        return studentIDs.contains(username);
    }

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
    public void saveUser(CreateStudentDsModel student) {
        Map<String, Float> courses = student.getCourseList();
        addStudent(student.getUsername(), student.getPassword(), courses);
    }

    @Override
    public void saveGPA(EvaluatorDbRequestModel requestModel) {
        int studentIndex = studentIDs.indexOf(requestModel.getStudentID());
        Map<String, Float> courseStudent = courses.get(studentIndex);
        courseStudent.put(requestModel.getCourseID(), requestModel.getGrade());
    }
}
