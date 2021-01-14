package com.example.authserver.mock;

import com.example.authserver.pojo.AuthInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jayying
 * @since 2021/1/13
 */
public class AuthInfoDB {
    private static final List<AuthInfo> authInfos = new ArrayList<>();

    static {
        authInfos.add(new AuthInfo("qq", "http://www.qq.com", "qqid123", "qqcode123"));
        authInfos.add(new AuthInfo("豆瓣", "http://127.0.0.1:8083/login/callBack", "o9Lb7Yew", "lzAeriN6E7RVj6H"));
    }

    public static boolean exist(AuthInfo authInfo) {
        for (AuthInfo info : authInfos) {
            if (info.equals(authInfo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean appIdExist(AuthInfo authInfo) {
        for(AuthInfo info : authInfos) {
            if(info.getAppId().equals(authInfo.getAppId())) {
                return true;
            }
        }
        return false;
    }

    public static void add(AuthInfo authInfo) {
        authInfos.add(authInfo);
    }

    public static List<AuthInfo> getAuthInfos() {
        return authInfos;
    }
}
