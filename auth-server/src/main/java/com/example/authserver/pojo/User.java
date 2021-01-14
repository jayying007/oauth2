package com.example.authserver.pojo;

/**
 * @author jayying
 * @since 2021/1/13
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return this.username.equals(user.username) && this.password.equals(user.password);
    }
}
