package org.rainO_o.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestApiClient {
    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();

        System.out.println(json);
    }
}
