package com.example.authserver.controller;

import com.example.authserver.mock.AuthInfoDB;
import com.example.authserver.mock.UserDB;
import com.example.authserver.pojo.AuthInfo;
import com.example.authserver.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jayying
 * @since  2021/1/13
 */
@Controller
@RequestMapping("user")
public class LoginController {
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    @ResponseBody
    public Result login(@RequestBody User user, HttpServletRequest request) {
        System.out.println("username:" + user.getUsername());
        System.out.println("password:" + user.getPassword());

        if(UserDB.exist(user)) {
            request.getSession().setAttribute("user", user);
            //账号验证正确，开始准备授权
            String appId = request.getParameter("appId");
            String callBackUrl = request.getParameter("callBackUrl");

            System.out.println("appId:" + appId);
            System.out.println("callBackUrl:" + callBackUrl);

            AuthInfo authInfo = new AuthInfo();
            authInfo.setAppId(appId);
            authInfo.setCallBackUrl(callBackUrl);

            if(AuthInfoDB.appIdExist(authInfo)) {
                //为其生成一个授权码
                String authCode = "1234abcd";
                String data = callBackUrl + "?authCode=" + authCode;
                return new Result("success", data);
            } else {
                return new Result("fail", "该应用暂未申请第三方登录");
            }
        }
        return new Result("fail", "账号或密码错误");
    }

    static class Result {
        private String msg;
        private String data;

        public Result(String msg, String data) {
            this.msg = msg;
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
