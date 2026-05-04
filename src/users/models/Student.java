package users.models;

import users.exceptions.InvalidLevelException;
import users.exceptions.InvalidProgressException;

import java.time.LocalDate;
import java.util.List;

public class Student extends User {

    private Level level;
    private int progress;



    public Student(int id, String firstname, String lastname, LocalDate birthday,
                   String email, String password,
                   String level, int progress) {

        super(id, firstname, lastname, birthday, email, password);

        setLevel(level);
        setProgress(progress);
        setDefaultPermissions();
    }

    //constructor fara id
    public Student(String firstname, String lastname, LocalDate birthday,
                   String email, String password, String level, int progress)  {
        super(firstname, lastname, birthday, email, password);
        setLevel(level);
        setProgress(progress);
        setDefaultPermissions();
    }


    public Student(String text) {
        super(text);
        String[] items = text.split(",");
        setLevel(items[7].trim());
        setProgress(Integer.parseInt(items[8].trim()));
        if (items.length > 9) {
            String[] permissions = items[9].trim().split(";");
            for (String permission : permissions) {
                super.permissions.add(Permissions.valueOf(permission.trim()));
            }
        } else {
            setDefaultPermissions();
        }

    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(String level) throws InvalidLevelException {

        boolean isNull = level == null;
        boolean isEmpty = level.isEmpty();

         if(isEmpty&&!isNull) {
             throw new InvalidLevelException();
         }
        this.level = Level.valueOf(level);

    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) throws InvalidProgressException {
        if (progress < 0 || progress > 180) {
            throw new InvalidProgressException();
        }


        this.progress = progress;
    }

    @Override
    public String toString() {
        return "STUDENT" + "," + super.toString() + "," + level + "," + progress +"," + permissionsToText();
    }

    private void setDefaultPermissions() {
        super.permissions.add(Permissions.READ_BOOK);
        super.permissions.add(Permissions.WRITE_BOOK);
        super.permissions.add(Permissions.READ_SCHEDULE);
        super.permissions.add(Permissions.WRITE_SCHEDULE);
        super.permissions.add(Permissions.READ_ENROLMENT);
        super.permissions.add(Permissions.WRITE_ENROLMENT);
    }
}