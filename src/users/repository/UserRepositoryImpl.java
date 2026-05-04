package users.repository;

import users.exceptions.InvalidIdException;
import users.exceptions.UserNotFoundExeption;
import users.factory.UserFactory;
import users.factory.UserFactoryImpl;
import users.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.Permission;
import java.util.*;

import users.models.Permissions;

public class UserRepositoryImpl implements UserRepository {

    private final List<User> users;
    private final UserFactory userFactory;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
        this.userFactory = new UserFactoryImpl();
        this.loadUsers();

    }

    public void loadUsers() {
        try {
            File file = new File("src/users/data/users.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                User user = userFactory.createFromText(line);

                if (user != null) {
                    users.add(user);
                } else {
                    System.out.println("User could not be created from line: " + line);
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < users.size(); i++) {
            sb.append(users.get(i).toString());

            if (i < users.size() - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    private void saveUsers() {
        try {
            FileWriter fileWriter = new FileWriter("src/users/data/users.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(this);

            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //generate id
    private int randomInt() {
        Random random = new Random();
        int id = random.nextInt(10000);
        return id;
    }

    private int generateId() {
        int id = randomInt();
        while (findUserById(id) != null) {
            id = randomInt();
        }

        return id;
    }

    @Override
    public User saveUser(User user) throws InvalidIdException {
        user.setId(generateId());
        this.users.add(user);
        saveUsers();
        return user;
    }

    @Override
    public User removeUser(User user) {
        User found = findUserById(user.getId());

        if (found != null) {
            users.remove(found);
            saveUsers();
            return found;
        }

        return null;
    }

    @Override
    public List<User> getUsers() {
        return this.users;
    }

    @Override
    public User findUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }



    @Override
    public User findUserByEmail(String email) {
       return users.stream().filter(user -> user.getEmail().equals(email))
               .findFirst().orElse(null);

    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {

        User found = findUserByEmail(email);
        if(found !=null && found.getPassword().equals(password)){
            return found;
        }
        return null;
    }

    @Override
    public User addPermissonsToUser(int id, Permissions permission) {
        User user = findUserById(id);

        if (user == null) {
            throw new UserNotFoundExeption();
        }
        user.addPermissions(permission);
        saveUsers();
        return user;
    }

    @Override
    public User removePermissonsFromUser(int id, Permissions permission) {
        User user = findUserById(id);
        if(user == null){
            throw new UserNotFoundExeption();
        }
        user.removePermissions(permission);
        saveUsers();
        return user;
    }

//todo:testare impl collection

    public void sortUsersById(){
        users.sort((u1,u2)->u1.getId()-u2.getId());
    }

    public void reverseUsers(){
        Collections.reverse(users);
    }
    public void shuffleUsers(){
        Collections.shuffle(users);
    }

    public User binarySearchById(int id){
        sortUsersById();
        int index = Collections.binarySearch(users, null, (u1, u2) -> u1.getId() - id);

        if(index >= 0){
            return users.get(index);
        }
        return null;
    }





}
