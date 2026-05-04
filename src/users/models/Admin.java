package users.models;

import java.time.LocalDate;

public class Admin extends User {


    public Admin(String firstname, String lastname, LocalDate birthday,
                 String email, String password) {
        super(firstname, lastname, birthday, email, password);
        setDefaultPermissions();
    }

    public Admin(String text) {
        super(text);
        String[] items = text.split(",");
        if(items.length > 7) {
            String[] permissions = items[7].trim().split(";");
            for(String permission : permissions) {
                super.permissions.add(Permissions.valueOf(permission.trim()));
            }

        }else {
            setDefaultPermissions();
        }
    }

    private void setDefaultPermissions() {
        super.permissions.add(Permissions.READ_STUDENT);
        super.permissions.add(Permissions.WRITE_STUDENT);
        super.permissions.add(Permissions.READ_TEACHER);
        super.permissions.add(Permissions.WRITE_TEACHER);
        super.permissions.add(Permissions.READ_COURSE);
        super.permissions.add(Permissions.WRITE_COURSE);

        super.permissions.add(Permissions.READ_BOOK);
        super.permissions.add(Permissions.WRITE_BOOK);
        super.permissions.add(Permissions.READ_SCHEDULE);
        super.permissions.add(Permissions.WRITE_SCHEDULE);
        super.permissions.add(Permissions.READ_ENROLMENT);
        super.permissions.add(Permissions.WRITE_ENROLMENT);

        super.permissions.add(Permissions.READ_PERMISSIONS);
        super.permissions.add(Permissions.WRITE_PERMISSIONS);
    }

    @Override
    public String toString() {
        return "ADMIN" + "," + super.toString() + "," + permissionsToText();
    }

}
