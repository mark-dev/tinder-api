package com.djm.tinder.objects;

/**
 * Created by lorenzo on 5/21/17.
 */
public class TokenResponse {
    private Token api_token;

    public TokenResponse(Token api_token) {
        this.api_token = api_token;
    }

    public Token getApi_token() {
        return api_token;
    }
}
