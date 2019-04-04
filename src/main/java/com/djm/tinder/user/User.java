package com.djm.tinder.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author Diego Mariani
 * @since 05-2017
 */
public class User {
    private Long distance;
    private int gender;
    private String id;
    private Date birthDate;
    private String name;
    private String contentHash;
    private String sNumber;
    private ArrayList<Photo> photos;
    private String bio;

    /**
     * @return User
     */
    public static User Builder() {
        return new User();
    }

    /**
     * @return Long
     */
    public Long getDistance() {
        return distance;
    }

    /**
     * @param distance of the user from my location
     * @return User object
     */
    public User setDistance(Long distance) {
        this.distance = distance;

        return this;
    }

    public int getGender() {
        return gender;
    }

    /**
     * @param gender the gender of the user
     * @return
     */
    public User setGender(int gender) {
        this.gender = gender;

        return this;
    }

    /**
     * @return the user's id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     * @return
     */
    public User setId(String id) {
        this.id = id;

        return this;
    }

    /**
     * @return the birthday of the user
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate
     * @return
     */
    public User setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * @return the content hash of the recommendation. Used for liking a recommended user.
     */
    public String getContentHash() {
        return contentHash;
    }

    /**
     * @param contentHash the content hash
     * @return user object
     */
    public User setContentHash(String contentHash) {
        this.contentHash = contentHash;
        return this;
    }

    /**
     * @return list of the user pictures
     */
    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    /**
     * @param photos
     * @return user object
     */
    public User setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
        return this;
    }

    /**
     * @return user additional number
     */
    public String getsNumber() {
        return sNumber;
    }

    /**
     * @param sNumber
     * @return
     */
    public User setsNumber(String sNumber) {
        this.sNumber = sNumber;
        return this;
    }

    /**
     * @param name the name of the user
     * @return
     */
    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}