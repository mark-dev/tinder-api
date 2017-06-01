## A Java implementation of tinder's HTTP API

[![Build Status](https://travis-ci.org/0x13a/tinder-api.svg?branch=master)](https://travis-ci.org/0x13a/tinder-api)

A minimal and handy java sdk for tinder's HTTP API

### Getting started

You can use maven to install the package. Add this to your `pom.xml` file

```xml
<dependency>
  <groupId>com.github.0x13a</groupId>
  <artifactId>tinder-api</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

### Quick guide

This is an example on how you want to use it. First you need to [retrieve your Facebook access token](#get-your-facebook-access-token) for the tinder app. Then you are ready to start.

#### Getting profile information

```java

import com.djm.tinder.*;

public class App {
    public static void main(String[] args) {
        try {
            final Tinder tinder = Tinder.fromAccessToken("AFD4C0jKqYf1y1NWeJzaZ8Vv0r4kNaXD");
            Profile profile = tinder.getProfile();
            System.out.println(String.format("About me: %s", profile.getName()));
        } catch (AuthenticationException e) {
            System.out.println("Whoops, unable to authenticate to the tinder API. Check your Facebook access token / app's permissions.");
        }
    }
}
```

#### Retrieve list of recommendations

```java

import com.djm.tinder.*;

public class App {
    public static void main(String[] args) {
        try {
            final Tinder tinder = Tinder.fromAccessToken("AFD4C0jKqYf1y1NWeJzaZ8Vv0r4kNaXD");
            final ArrayList<User> users = tinder.getRecommendations();
            for (User user : users) {
                System.out.println(String.format("See %s", user.getName()));
            }
        } catch (AuthenticationException e) {
            System.out.println("Whoops, unable to authenticate to the tinder API. Check your Facebook access token / app's permissions.");
        }
    }
}
```

#### Like user

```java

import com.djm.tinder.*;

public class App {
    public static void main(String[] args) {
        try {
            final Tinder tinder = Tinder.fromAccessToken("AFD4C0jKqYf1y1NWeJzaZ8Vv0r4kNaXD");
            final ArrayList<User> users = tinder.getRecommendations();
            Like like = tinder.like(users.get(0));
            if (like.isMatch() == true) {
                System.out.println(String.format("Matched with %s!", user.getName()));
            }
        } catch (AuthenticationException e) {
            System.out.println("Whoops, unable to authenticate to the tinder API. Check your Facebook access token / app's permissions.");
        }
    }
}
```

Many more to come. Check the api doc for more.

### Get your Facebook Access Token

In order to work, the Tinder java client (even your tinder app) needs an access token.
This access Token is gonna be used in each call to the Tinder api. To obtain the Tinder access token we have to call the `https://gotinder.com/v2/auth` endpoint
where you need to provide your facebook access token
granted to the Tinder app. This will allow tinder to access your facebook info (name, pics, email, friends, likes).

The **Facebook Access Token** is the only thing you need to get started.
If you are smart enough, you can find it here [Facebook's Tinder App permission](https://www.facebook.com/v2.6/dialog/oauth?redirect_uri=fb464891386855067%3A%2F%2Fauthorize%2F&scope=user_birthday,user_photos,user_education_history,email,user_relationship_details,user_friends,user_work_history,user_likes&response_type=token%2Csigned_request&client_id=464891386855067)

### Documentation

You can check **javadoc** here [https://0x13a.github.io/tinder-api/](https://0x13a.github.io/tinder-api/)

### License

This software is licenced under the [Beerware License](https://fedoraproject.org/wiki/Licensing/Beerware). For more insights, please check [LICENSE](LICENSE) file