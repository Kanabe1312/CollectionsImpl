package users.factory;

import users.models.Student;
import users.models.Teacher;
import users.models.User;
import users.models.Admin;
import java.time.LocalDate;

public class UserFactoryImpl implements UserFactory {

    @Override
    public User createFromText(String text) {
        String[] parts = text.split(",");
        String type = parts[0];
        return switch (type) {
            case "STUDENT" -> new Student(text);
            case "TEACHER" -> new Teacher(text);
            case "ADMIN" -> new Admin(text);
            default -> null;
        };
    }

    @Override
    public User createStudent(String firstname, String lastname, LocalDate birthday,
                              String email, String password, String level, int progress) {
        return new Student(firstname, lastname, birthday, email, password, level, progress);
    }

    public User createTeacher(String firstname, String lastname, LocalDate birthday,
                              String email, String password, String subject,
                              boolean isDoctorat) {
        return new Teacher(firstname, lastname, birthday, email, password, subject, isDoctorat);
    }

    @Override
    public User createAdmin(String firstname, String lastname, LocalDate birthday,
                            String email, String password) {
        return new Admin(firstname, lastname, birthday, email, password);
    }
}