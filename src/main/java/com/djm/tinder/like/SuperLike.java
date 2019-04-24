package com.djm.tinder.like;

import java.time.Instant;

public class SuperLike {
    private boolean limitExceeded;
    private boolean isMatch;
    private int status;
    private Instant resetAt;

    public boolean isLimitExceeded() {
        return limitExceeded;
    }

    public SuperLike setLimitExceeded(boolean limitExceeded) {
        this.limitExceeded = limitExceeded;
        return this;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public SuperLike setMatch(boolean match) {
        isMatch = match;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public SuperLike setStatus(int status) {
        this.status = status;
        return this;
    }

    public boolean isSuccessfully() {
        return status == 200 && !limitExceeded;
    }

    public SuperLike setResetAt(Instant resetAt) {
        this.resetAt = resetAt;
        return this;
    }

    public Instant getResetAt() {
        return resetAt;
    }

    @Override
    public String toString() {
        return "SuperLike{" +
                "limitExceeded=" + limitExceeded +
                ", isMatch=" + isMatch +
                ", status=" + status +
                ", resetAt=" + resetAt +
                '}';
    }
}
