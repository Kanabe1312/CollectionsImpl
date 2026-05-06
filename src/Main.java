import users.repository.UserRepositoryImpl;
import users.models.User;

import java.util.List;

public class Main {

    public static void printUsers(String title, List<User> users) {
        System.out.println("\n=== " + title + " ===");

        for (User u : users) {
            System.out.println(u);
        }
    }

    public static void main(String[] args) {

        UserRepositoryImpl repo = new UserRepositoryImpl();

        printUsers("ORIGINAL", repo.getUsers());

        repo.sortUsersById();
        printUsers("SORT BY ID", repo.getUsers());

        repo.reverseUsers();
        printUsers("REVERSED", repo.getUsers());

        repo.shuffleUsers();
        printUsers("SHUFFLED", repo.getUsers());

        repo.getAdmins();
        printUsers("ADMINS: ",repo.getAdmins());

        repo.sortByFirstname();
        printUsers("FIRST NAME: ",repo.getUsers());



        User found = repo.binarySearchById(2001);


        System.out.println("\n=== SEARCH RESULT ===");
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("User not found");
        }
    }
}