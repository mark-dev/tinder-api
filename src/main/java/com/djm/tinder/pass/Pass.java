package com.djm.tinder.pass;

import com.djm.tinder.like.Like;

public class Pass {
    private int status;

    public int getStatus() {
        return status;
    }

    public Pass setStatus(int status) {
        this.status = status;
        return this;
    }

    public static Pass Builder() {
        return new Pass();
    }
}
