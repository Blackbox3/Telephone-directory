package com.college.campaign.web.login.hmac;

public interface CredentialsProvider {

    byte[] getApiSecret(String apiKey);
}
