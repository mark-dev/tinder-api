package com.djm.tinder.recommendation;

import java.util.Date;

public class Recommendation {
	private int distance;
    private int connectionCount;
    private String contentHash;
    private int id;
    private Date birthDate;
    private String name;

    public static Recommendation Builder() {
        return new Recommendation();
    }

    public int getDistance() {
        return distance;
    }

    public Recommendation setDistance(int distance) {
        this.distance = distance;

        return this;
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public Recommendation setConnectionCount(int connectionCount) {
        this.connectionCount = connectionCount;

        return this;
    }

    public String getContentHash() {
        return contentHash;
    }

    public Recommendation setContentHash(String contentHash) {
        this.contentHash = contentHash;

        return this;
    }

    public int getId() {
        return id;
    }

    public Recommendation setId(int id) {
        this.id = id;

        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Recommendation setBirthDate(Date birthDate) {
        this.birthDate = birthDate;

        return this;
    }

    public String getName() {
        return name;
    }

    public Recommendation setName(String name) {
        this.name = name;

        return this;
    }
}