package com.djm.tinder.pass;

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

    @Override
    public String toString() {
        return "Pass{" +
                "status=" + status +
                '}';
    }
}
