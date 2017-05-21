package com.djm.tinder.objects;

/**
 * Created by lorenzo on 5/21/17.
 */
public class AuthResponse {
    private TokenResponse data;

    public AuthResponse(TokenResponse data) {
        this.data = data;
    }

    public TokenResponse getData() {
        return data;
    }
}
