package com.djm.tinder.objects;

import com.sun.istack.internal.NotNull;

/**
 * Created by lorenzo on 5/21/17.
 */
public class Token {
    private String token;

    public Token(@NotNull String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
