package com.djm.tinder.profile;

import java.util.Date;

public class Position {

    private double lat;
    private double lon;
    private Date lastRecordedAt;

    public double getLat() {
        return lat;
    }

    public Position setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLon() {
        return lon;
    }

    public Position setLon(double lon) {
        this.lon = lon;
        return this;
    }

    public Date getLastRecordedAt() {
        return lastRecordedAt;
    }

    public Position setLastRecordedAt(Date lastRecordedAt) {
        this.lastRecordedAt = lastRecordedAt;
        return this;
    }

    public static Position Builder() {
        return new Position();
    }
}
