### An Unofficial Java implementation of tinder's HTTP API

Hey, this is an unofficial Java implementation of tinder's HTTP API

#### Installation

You can use maven to install the package. Add this to your `pom.xml` file

```xml
<dependency>
  <groupId>com.djm</groupId>
  <artifactId>tinder</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### Example

This is an example on how you want to use it

```java

import com.djm.tinder.Tinder;
import com.djm.tinder.Recommendation;

public class App {
    public static void main(String[] args) {
        Tinder tinder = Tinder.fromAccessToken("yourFacebookAccessTokenForTinderApp");
        ArrayList<Recommendation> recommendations = tinder.getRecommendations();
        for (Recommendation rec : recommendations) {
            User user = rec.getUser();
            tinder.message(user, "Hey");
        }
    }
}
```
