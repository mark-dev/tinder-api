package com.djm.tinder;

public class App {

    public static void main(String[] args) {
        try {
            Tinder t = new Tinder("");
            t.getRecommendations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
