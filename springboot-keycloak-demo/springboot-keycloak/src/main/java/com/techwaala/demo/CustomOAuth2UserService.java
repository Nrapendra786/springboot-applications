package com.techwaala.demo;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2AccessToken accessToken = userRequest.getAccessToken();
        //OAuth2RefreshToken refreshToken = userRequest.getAccessToken();

        // Log the access token and refresh token
        System.out.println("Access Token: " + accessToken.getTokenValue());
       // System.out.println("Refresh Token: " + (refreshToken != null ? refreshToken.getTokenValue() : "No refresh token"));

        // Proceed with the default behavior (you can also customize it)
        return new DefaultOAuth2UserService().loadUser(userRequest);
    }
}
