package com.djm.tinder.http.client;

import com.djm.tinder.http.request.HttpGetRequest;
import com.djm.tinder.http.request.HttpPostRequest;

import java.io.IOException;

/**
 * @author Diego Mariani
 * @since 05-2017
 */
public interface HttpClient {
    String post(HttpPostRequest httpPostRq) throws IOException;
    String get(HttpGetRequest httpGetRq) throws IOException;
}
