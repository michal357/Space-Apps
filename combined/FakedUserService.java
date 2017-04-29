package com.example.aleksandra.combined;

/**
 * Created by Aleksandra on 29.04.2017.
 */

        import java.util.ArrayList;
        import java.util.List;

public class FakedUserService implements IUserService {
    private static List<User> users = new ArrayList<>();
    public FakedUserService() {
        users = new ArrayList<>();
        if (users.isEmpty()) {
            users.add(new User("User1", 23));
            users.add(new User("User2", 432));
            users.add(new User("User3", 634));
            users.add(new User("User4", 12));
            users.add(new User("User5", 6));
            users.add(new User("User6", 236));
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
