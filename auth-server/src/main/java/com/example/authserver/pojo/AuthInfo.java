package com.example.authserver.pojo;

/**
 * @author jayying
 * @since 2021/1/13
 */
public class AuthInfo {
    private String appName;
    private String callBackUrl;
    private String appId;
    private String appSecret;

    public AuthInfo() {

    }
    public AuthInfo(String appName, String callBackUrl, String appId, String appSecret) {
        this.appName = appName;
        this.callBackUrl = callBackUrl;
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
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

    @Override
    public boolean equals(Object obj) {
        AuthInfo authInfo = (AuthInfo) obj;
        return this.appId.equals(authInfo.appId) && this.appSecret.equals(authInfo.appSecret);
    }
}
