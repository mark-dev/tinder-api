package com.djm.tinder.http;

import java.io.IOException;

public interface HttpClient {
    String post(HttpPostRq httpPostRq) throws IOException;
    String get(HttpGetRq httpGetRq) throws IOException;
}
