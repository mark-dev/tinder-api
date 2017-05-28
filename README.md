## An Unofficial Java implementation of tinder's HTTP API

[![Build Status](https://travis-ci.org/0x13a/tinder-api.svg?branch=master)](https://travis-ci.org/0x13a/tinder-api)

This is an unofficial Java implementation of tinder's HTTP API. It's a http java client designed to be minimal and easy to use.

### Installation

You can use maven to install the package. Add this to your `pom.xml` file

```xml
<dependency>
  <groupId>com.djm</groupId>
  <artifactId>tinder</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Example

This is an example on how you want to use it

```java

import com.djm.tinder.Tinder;
import com.djm.tinder.user.User;
import com.djm.tinder.like.Like;

public class App {
    public static void main(String[] args) {
        try {
            final Tinder tinder = Tinder.fromAccessToken("yourFacebookAccessTokenForTinderApp");
            final ArrayList<User> users = tinder.getRecommendations();
            for (User user : users) {
                Like like = tinder.like(user);
                if (like.isMatch() == true) {
                    System.out.println(String.format("Matched with %s!", user.getName()));
                }
            }
            Profile profile = tinder.getProfile();
            System.out.println(String.format("About me: %s", profile.getName()));
        } catch (AuthenticationException e) {
            System.out.println("Whoops, unable to authenticate to the tinder API. Check your Facebook access token / app's permissions.");
        }
    }
}
```

### Get your Facebook Access Token

In order to work, the Tinder java client (even your tinder app) needs an access token.
This access Token is gonna be used in each call to the Tinder api. To obtain the Tinder access token we have to call the `https://gotinder.com/v2/auth` endpoint
where you need to provide your facebook access token
granted to the Tinder app. This will allow tinder to access your facebook info (name, pics, email, friends, likes).

The **Facebook Access Token** is the only thing you need to get started.
If you are smart enough, you can find it here [Facebook's Tinder App permission](https://www.facebook.com/v2.6/dialog/oauth?redirect_uri=fb464891386855067%3A%2F%2Fauthorize%2F&scope=user_birthday,user_photos,user_education_history,email,user_relationship_details,user_friends,user_work_history,user_likes&response_type=token%2Csigned_request&client_id=464891386855067)

### Documentation

You can check [javadoc](https://0x13a.github.io/tinder-api/)

### License

This software is licenced under the [Beerware License](https://fedoraproject.org/wiki/Licensing/Beerware). For more insights, please check [LICENSE](LICENSE) file