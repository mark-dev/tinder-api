package com.djm.tinder.recommendation;

import com.djm.tinder.profile.ProcessedPhoto;

import java.util.ArrayList;

public class Photo {
    private String id;
    private String fileName;
    private String extension;
    private String url;
    private double xDistancePercent;
    private double yDistancePercent;
    private double xOffsetPercent;
    private double yOffsetPercent;
    private int main;
    private ArrayList<ProcessedPhoto> processedPhotos;

    public String getId() {
        return id;
    }

    public Photo setId(String id) {
        this.id = id;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public Photo setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public Photo setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Photo setUrl(String url) {
        this.url = url;
        return this;
    }

    public double getxDistancePercent() {
        return xDistancePercent;
    }

    public Photo setxDistancePercent(double xDistancePercent) {
        this.xDistancePercent = xDistancePercent;
        return this;
    }

    public double getyDistancePercent() {
        return yDistancePercent;
    }

    public Photo setyDistancePercent(double yDistancePercent) {
        this.yDistancePercent = yDistancePercent;
        return this;
    }

    public double getxOffsetPercent() {
        return xOffsetPercent;
    }

    public Photo setxOffsetPercent(double xOffsetPercent) {
        this.xOffsetPercent = xOffsetPercent;
        return this;
    }

    public double getyOffsetPercent() {
        return yOffsetPercent;
    }

    public Photo setyOffsetPercent(double yOffsetPercent) {
        this.yOffsetPercent = yOffsetPercent;
        return this;
    }

    public int getMain() {
        return main;
    }

    public Photo setMain(int main) {
        this.main = main;
        return this;
    }

    public ArrayList<ProcessedPhoto> getProcessedPhotos() {
        return processedPhotos;
    }

    public Photo setProcessedPhotos(ArrayList<ProcessedPhoto> processedPhotos) {
        this.processedPhotos = processedPhotos;
        return this;
    }
}
