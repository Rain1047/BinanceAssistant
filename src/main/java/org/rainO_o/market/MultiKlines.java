package org.rainO_o.market;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;

import static org.rainO_o.config.PrivateConfig.API_KEY;
import static org.rainO_o.config.PrivateConfig.SECRET_KEY;

public class MultiKlines {
    private MultiKlines(){

    }

    public static void main(String[] args) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(API_KEY, SECRET_KEY);
        BinanceApiRestClient client = factory.newRestClient();

    }
}
