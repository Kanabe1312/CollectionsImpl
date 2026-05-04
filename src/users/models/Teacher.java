package users.models;

import users.exceptions.InvalidSubjectException;

import java.time.LocalDate;
import java.util.List;

public class Teacher extends User{

    private String subject;
    private boolean isDoctorat;


    //constructor cu id
    public Teacher(int id, String firstname, String lastname, LocalDate birthday,
                   String email, String password,  String subject,
                   boolean isDoctorat)  {

        super(id, firstname, lastname, birthday, email, password);

        this.subject = subject;
        this.isDoctorat = isDoctorat;
        setDefaultPermissions();
    }

    //constructor fara id
    public Teacher(String firstname, String lastname, LocalDate birthday,
                   String email, String password, String subject,
                   boolean isDoctorat) {

        super(firstname, lastname, birthday, email, password);

        this.subject = subject;
        this.isDoctorat = isDoctorat;
        setDefaultPermissions();
    }


    public Teacher(String text) {
        super(text);
        String[] items = text.split(",");
        setSubject(items[7].trim());
        setDoctorat(Boolean.parseBoolean(items[8].trim()));
        if (items.length > 9) {
            String[] permissions = items[9].trim().split(";");
            for (String permission : permissions) {
                super.permissions.add(Permissions.valueOf(permission.trim()));
            }
        } else {
            setDefaultPermissions();
        }

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) throws InvalidSubjectException {
        if (subject == null || subject.isEmpty()) {
            throw new InvalidSubjectException();
        }
        this.subject = subject;
    }

    public boolean getisDoctorat() {
        return isDoctorat;
    }

    public void setDoctorat(boolean doctorat) {

        this.isDoctorat = doctorat;
    }

    @Override
    public String toString() {
        return "TEACHER" + "," + super.toString() + "," + subject + "," + isDoctorat +"," + permissionsToText();
    }

    private void setDefaultPermissions() {
        super.permissions.add(Permissions.READ_STUDENT);
        super.permissions.add(Permissions.WRITE_STUDENT);
        super.permissions.add(Permissions.READ_TEACHER);
        super.permissions.add(Permissions.WRITE_TEACHER);
        super.permissions.add(Permissions.READ_COURSE);
        super.permissions.add(Permissions.WRITE_COURSE);
    }
}