package djm.tinder.auth;

import djm.tinder.http.HttpPostRq;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class AuthRq implements HttpPostRq {

    public static final String URI = "/v2/auth";

    private String url;
    private String token;

    public AuthRq(String url, String token) {
        this.url = url;
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        JSONObject obj = new JSONObject();
        obj.put("token", token);

        return obj.toString();
    }

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();

        return headers;
    }
}
