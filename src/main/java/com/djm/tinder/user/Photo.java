package com.djm.tinder.user;

import com.djm.tinder.profile.ProcessedPhoto;

import java.util.ArrayList;

public class Photo {
    private String id;
    private String url;
    private ArrayList<ProcessedPhoto> processedPhotos;

    public String getId() {
        return id;
    }

    public Photo setId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Photo setUrl(String url) {
        this.url = url;
        return this;
    }

    public ArrayList<ProcessedPhoto> getProcessedPhotos() {
        return processedPhotos;
    }

    public Photo setProcessedPhotos(ArrayList<ProcessedPhoto> processedPhotos) {
        this.processedPhotos = processedPhotos;
        return this;
    }

    public static Photo Builder() {
        return new Photo();
    }
}
