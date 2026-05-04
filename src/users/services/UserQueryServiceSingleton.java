package users.services;

public class UserQueryServiceSingleton {


    private static final UserQueryService instance = new UserQueryServiceImpl();
    public static UserQueryService getInstance() {
        return instance;
    }
}


