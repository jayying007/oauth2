package com.example.authserver.controller;

import com.example.authserver.mock.AuthInfoDB;
import com.example.authserver.pojo.AuthInfo;
import com.example.authserver.util.CodeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jayying
 * @since 2021/1/13
 */
@Controller
@RequestMapping("auth")
public class AuthController {
    @PostMapping("new")
    @ResponseBody
    public String addAuth(@RequestBody AuthInfo authInfo, Model model) {
        String appId = CodeUtils.getRandomCode(8);
        String appSecret = CodeUtils.getRandomCode(15);

        authInfo.setAppId(appId);
        authInfo.setAppSecret(appSecret);
        AuthInfoDB.add(authInfo);

        model.addAttribute("allAuths", AuthInfoDB.getAuthInfos());

        return "success";
    }

    @PostMapping("token")
    @ResponseBody
    public Result getAccessToken(@RequestBody TokenInfo tokenInfo) {
        System.out.println("换取Token:" + tokenInfo.toString());
        AuthInfo authInfo = new AuthInfo();
        //验证authCode等信息
        authInfo.setAppId(tokenInfo.appId);
        authInfo.setAppSecret(tokenInfo.appSecret);
        if(AuthInfoDB.exist(authInfo)) {
            System.out.println("exist");
            return new Result("access123abc", "refresh123abc");
        }
        return null;
    }



    static class TokenInfo {
        private String appId;
        private String appSecret;
        private String authCode;

        public TokenInfo(String appId, String appSecret, String authCode) {
            this.appId = appId;
            this.appSecret = appSecret;
            this.authCode = authCode;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }

        public String getAuthCode() {
            return authCode;
        }

        public void setAuthCode(String authCode) {
            this.authCode = authCode;
        }

        @Override
        public String toString() {
            return "TokenInfo{" +
                    "appId='" + appId + '\'' +
                    ", appSecret='" + appSecret + '\'' +
                    ", authCode='" + authCode + '\'' +
                    '}';
        }
    }
    static class Result {
        private String accessToken;
        private String refreshToken;
        public Result(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }

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
}
