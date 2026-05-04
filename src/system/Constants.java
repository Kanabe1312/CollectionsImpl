package app.system;

public class Constants {
    //USER
    public static final String INVALID_ID = "Invalid ID,id must be positive";
    public final static String USER_ALREADY_EXISTS = "User already exists";
    public final static String USER_NOT_FOUND = "User Not Found";
    public final static String INVALID_FIRST_NAME = "Invalid First Name,First name must contain only letters";
    public final static String INVALID_LAST_NAME = "Invalid Last Name";
    public final static String INVALID_EMAIL = "Invalid Email" + "Email must contain @" + ".";
    public final static String INVALID_PASSWORD = "Password must have at least 8 characters";
    public final static String INVALID_BIRTHDAY = "Invalid Birthday";
    public final static String INVALIDE_USER_TYPE = "Invalid User Type";
    //STUDENT
    public final static String INVALID_LEVEL = "Level must be Bachelor or Master";
    public final static String INVALIDE_PROGRESS = "Progress must be between 0 and 180 credits";
    //TEACHER
    public final static String INVALID_SUBJECT = "Subject cannot be empty";
    //BOOK
    public final static String INVALID_BOOK_NAME = "Invalid Book Name";
    public final static String INVALID_BOOK_ID = "Invalid Book ID";
    public final static String INVALID_STUDENT_ID = "Invalid Student ID";
    public final static String INVALID_BOOK_CREATED = "Invalid date";
    //COURSE
    public final static String INVALID_COURSE_ID = "Invalid ID";
    public final static String INVALID_COURSE_NAME = "Invalid Course Name";
    public final static String INVALID_COURSE_DEPARTMENT = "Invalid Course Department";
    //ENROLMENT
    public final static String INVALID_ENROLMENT_COURSE_ID= "Invalid courseId: must be a positive number.";
    public final static String INVALID_ENROLMENT_ID = "invalid Enrolment Id";
    public final static String INVALID_ENROLMENT_STUDENT_ID = "Invalid Student ID";
    public final static String INVALID_ENROLMENT_DATE = "Invalid Enrolment Date";
    //SCHEDULE
    public final static String INVALID_SCHEDULE_ID = "Invalid Schedule ID";
    public final static String INVALID_SCHEDULE_STUDENT_ID = "Invalid Student ID";
    public final static String INVALID_SCHEDULE_SUBJECT = "Invalid suject";
    public final static String INVALID_SCHEDULE_DAY = "Invalid date";
    public final static String INVALID_SCHEDULE_DURATION = "Invalid duration";


}
