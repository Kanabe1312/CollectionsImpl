package users.services;

public class UserCommandServiceSingleton {
    private static final UserCommandSerice instance = new UserCommandServiceImpl();

    public static UserCommandSerice getInstance() {

        return instance;
    }

}
