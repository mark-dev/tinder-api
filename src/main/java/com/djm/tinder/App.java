package com.djm.tinder;

public class App {

    public static void main(String[] args) {
        try {
            Tinder tinder = Tinder.fromAccessToken("");
            tinder.getRecommendations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
