package com.djm.tinder;

import com.djm.tinder.recommendation.Recommendation;

public class App {

    public static void main(String[] args) {
        try {
            Tinder tinder = Tinder.fromAccessToken("EAAGm0PX4ZCpsBAEMjrlNKeYlY4ES1C9vRLEzzmVctgn3NrEg1l5XKyYzpm7sInsv06Su3P9pIbiBvbtZCk443VdZCamswOA2JEXJQ0x1E8bZB6ZBWQpZAjty0rN0JRQg0y0rdP8vcjZA18busWBX06vA7gaqREy1Wp1I4HzvwtkGyGhzQurzjjSpFZBiI8ZAO6GYrhEB5UEjGVohydMV5d7ZBhed8qLmnl9LEZD");
            for (Recommendation r : tinder.getRecommendations()) {
                System.out.println(r.getName() + " " + r.getBirthDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
