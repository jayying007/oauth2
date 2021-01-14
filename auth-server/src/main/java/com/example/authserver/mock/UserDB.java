package com.example.authserver.mock;

import com.example.authserver.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jayying
 * @since 2021/1/13
 */
public class UserDB {
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("123", "123456"));
        users.add(new User("456", "123456"));
        users.add(new User("789", "123456"));
    }

    public static boolean exist(User user) {
        for (User value : users) {
            if (value.equals(user)) {
                return true;
            }
        }
        return false;
    }
}
