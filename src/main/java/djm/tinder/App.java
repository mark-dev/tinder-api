package djm.tinder;

public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to my version of Tinder api");

        try {
            Tinder t = new Tinder("");
            t.getRecommendations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
