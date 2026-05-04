package users.factory;

import users.models.User;
import users.models.Admin;
import java.time.LocalDate;

public interface UserFactory {

    User createFromText(String text);

    User createStudent(String firstname, String lastname, LocalDate birthday,
                       String email, String password, String level, int progress);

    User createTeacher(String firstname, String lastname, LocalDate birthday,
                       String email, String password, String subject,
                       boolean isDoctorate);

    User createAdmin(String firstname, String lastname, LocalDate birthday,
                     String email, String password);
}