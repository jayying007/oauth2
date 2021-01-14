package com.example.resourceserver.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author jayying
 * @since 2021/1/14
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("info")
    public User getUserInfo(@RequestHeader("Authorization") String accessToken) {
        User user = new User();
        if(isValid(accessToken)) {
            user.name = "Jayying007";
            user.gender = "Man";
            user.hobby = "Programming";
        }
        return user;
    }

    /**
     * 向Auth Server验证令牌的正确性
     * @param accessToken 令牌
     * @return 判断是否有效
     */
    public boolean isValid(String accessToken) {
        return "access123abc".equals(accessToken);
    }

    static class Request {
        private String accessToken;
        private String refreshToken;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }
    static class User {
        private String name;
        private String gender;
        private String hobby;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", hobby='" + hobby + '\'' +
                    '}';
        }
    }
}
