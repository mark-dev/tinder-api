package com.djm.tinder.recommendation;

import java.util.ArrayList;
import java.util.Date;

public class User {
	private Long distance;
    private int gender;
    private String id;
    private Date birthDate;
    private String name;
    private String contentHash;
    private String sNumber;
    private ArrayList<Photo> photos;

    public static User Builder() {
        return new User();
    }

    public Long getDistance() {
        return distance;
    }

    public User setDistance(Long distance) {
        this.distance = distance;

        return this;
    }

    public int getGender() {
        return gender;
    }

    public User setGender(int gender) {
        this.gender = gender;

        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;

        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public User setBirthDate(Date birthDate) {
        this.birthDate = birthDate;

        return this;
    }

    public String getName() {
        return name;
    }

    public String getContentHash() {
        return contentHash;
    }

    public User setContentHash(String contentHash) {
        this.contentHash = contentHash;
        return this;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public User setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
        return this;
    }

    public String getsNumber() {
        return sNumber;
    }

    public User setsNumber(String sNumber) {
        this.sNumber = sNumber;
        return this;
    }

    public User setName(String name) {
        this.name = name;

        return this;
    }
}