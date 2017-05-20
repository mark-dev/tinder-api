package com.djm.tinder.recommendation;

import java.util.Date;

public class Recommendation {
	private Long distance;
    private int gender;
    private String id;
    private Date birthDate;
    private String name;

    public static Recommendation Builder() {
        return new Recommendation();
    }

    public Long getDistance() {
        return distance;
    }

    public Recommendation setDistance(Long distance) {
        this.distance = distance;

        return this;
    }

    public int getGender() {
        return gender;
    }

    public Recommendation setGender(int gender) {
        this.gender = gender;

        return this;
    }

    public String getId() {
        return id;
    }

    public Recommendation setId(String id) {
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