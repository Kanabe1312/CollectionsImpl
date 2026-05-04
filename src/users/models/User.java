package users.models;

import users.exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User {

    private int id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String email;
    private String password;
    private String type;
    protected List<Permissions> permissions= new ArrayList<>();

    //string text constructor
    public User(String text) {
        String[] items = text.split(",");
        setType(items[0].trim());
        setId(Integer.parseInt(items[1].trim()));
        setFirstname(items[2].trim());
        setLastname(items[3].trim());
        setBirthday(LocalDate.parse(items[4].trim()));
        setEmail(items[5].trim());
        setPassword(items[6].trim());
    }

    //constructor complet
    public User(int id, String firstname, String lastname, LocalDate birthday, String email,
                String password)  {
        this.id = id;
        this.setFirstname(firstname);
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }

    //constructor fara id
    public User(String firstname, String lastname, LocalDate birthday, String email,
                String password){

        this.setFirstname(firstname);
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return id + "," + firstname + "," + lastname + "," + birthday + "," + email + "," + password;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) throws InvalidIdException {
        if (id <= 0) {
            throw new InvalidIdException();
        }
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) throws InvalidFirstNameException {
        if (firstname == null || firstname.isEmpty()) {
            throw new InvalidFirstNameException();
        }
        if (!firstname.matches("[A-Za-z]+")) {
            throw new InvalidFirstNameException();
        }
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) throws InvalidLastNameException {
        if (lastname == null || lastname.isEmpty()) {
            throw new InvalidLastNameException();
        }
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) throws InvalidBirthdayException {
        if (birthday == null) {
            throw new InvalidBirthdayException();
        }

        if (birthday.isAfter(LocalDate.now())) {
            throw new InvalidBirthdayException();
        }
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException();
        }

        if (!email.contains("@")) {
            throw new InvalidEmailException();
        }

        if (!email.contains(".")) {
            throw new InvalidEmailException();
        }

        if (email.startsWith("@")) {
            throw new InvalidEmailException();
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {

        if (password == null || password.length() < 8) {
            throw new InvalidPasswordException();
        }

        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws InvalidUserTypeException {

        if (!type.equals("STUDENT") && !type.equals("TEACHER") && !type.equals("ADMIN")) {
            throw new InvalidUserTypeException();
        }

        this.type = type;
    }

    public boolean hasPermission(Permissions permission) {
        return permissions.contains(permission);
    }

    public String permissionsToText() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < permissions.size(); i++) {
            sb.append(permissions.get(i));

            if (i < permissions.size() - 1) {
                sb.append(";");
            }
        }

        return sb.toString();
    }

    //add erase

    public void addPermissions(Permissions permission){
        if(!permissions.contains(permission)){
          permissions.add(permission);
        }
    }
    public void removePermissions(Permissions permission){
        permissions.remove(permission);
    }

    public List<Permissions> getPermissions(){
        return permissions;
    }


}