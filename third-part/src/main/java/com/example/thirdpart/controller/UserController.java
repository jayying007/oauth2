package com.example.thirdpart.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jayying
 * @since 2021/1/14
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("info")
    public User getUserInfo() {
        //通过access_token获取信息
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", getAccessToken());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        //对方提供的openAPI
        User user = restTemplate.exchange("http://127.0.0.1:8082/user/info", HttpMethod.GET, request, User.class).getBody();

        return user;
    }

    /**
     * 获取之前已经存下来的access_token
     * @return
     */
    public String getAccessToken() {
        return "access123abc";
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
