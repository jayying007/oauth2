package com.example.thirdpart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

/**
 * @author jayying
 * @since 2021/1/14
 */
@Controller
@RequestMapping("login")
public class LoginController {
    private final String qqUrl = "http://127.0.0.1:8081/user/login";
    private final String qqTokenUrl = "http://127.0.0.1:8081/auth/token";
    private final String appId = "o9Lb7Yew";
    private final String appSecret = "lzAeriN6E7RVj6H";
    private final String callBackUrl = "http://127.0.0.1:8083/login/callBack";

    @GetMapping
    public String login() {
        return "login";
    }
    /**
     *
     * @return 返回第三方登录所需的信息
     */
    @GetMapping("third_part")
    public String loginWithThirdPart(HttpServletResponse response) {
        String redirectInfo = qqUrl + "?appId=" + appId + "&callBackUrl=" + callBackUrl;

        return "redirect:" + redirectInfo;
    }

    /**
     *
     * @return
     */
    @GetMapping("callBack")
    public String callBack(@RequestParam(value = "authCode") String authCode) {
        //用授权码换access_token
        TokenInfo tokenInfo = new TokenInfo(appId, appSecret, authCode);
        RestTemplate restTemplate = new RestTemplate();
        Result result = restTemplate.postForObject(qqTokenUrl, tokenInfo, Result.class);
        System.out.println("get token:" + result);

        return "redirect:/index";
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
    }
    static class Result {
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
}
