package com.djm.tinder;

import com.djm.tinder.recommendation.Recommendation;

public class App {

    public static void main(String[] args) {
        try {
            Tinder tinder = Tinder.fromAccessToken("");
            for (Recommendation r : tinder.getRecommendations()) {
                System.out.println(r.getName() + " " + r.getBirthDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
