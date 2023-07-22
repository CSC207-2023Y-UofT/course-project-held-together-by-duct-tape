package mocks;
import CreateStudentUsecase.*;
import java.util.*;

public class DummyDataGateway implements CreateStudentDataAccess {
    private static List<String> usernames = new ArrayList<String>();

    @Override
    public boolean isUnique(String username) {
        return !usernames.contains(username);
    }

    @Override
    public void save(CreateStudentDsModel student) {usernames.add(student.getUsername());
    }
}

