package users.repository;

import users.models.User;
import users.models.Permissions;

import java.util.List;

public interface UserRepository {


    User saveUser(User user);

    User removeUser(User user);

    List<User> getUsers();

    User findUserById(int id);

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

    User addPermissonsToUser(int id, Permissions  permission);

    User removePermissonsFromUser(int id,Permissions permission);


}
