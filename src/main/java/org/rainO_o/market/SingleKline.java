package org.rainO_o.market;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.binance.connector.client.impl.SpotClientImpl;
import org.rainO_o.config.PrivateConfig;
import org.rainO_o.config.SpringConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public final class SingleKline {

    private SingleKline() {

    }
    private static final Logger logger = LoggerFactory.getLogger(SingleKline.class);
    public static void main(String[] args) {

        System.out.println("Single Kline");

        /*
        client: create with spring
         */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

//        SpotClientImpl spotClient = new SpotClientImpl(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY); //old version
        SpotClientImpl spotClient = ctx.getBean(SpotClientImpl.class);
        System.out.println(spotClient);

        /*
        add parameters --> spring
         */
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        List<String> CryptoList = new ArrayList<>();
        CryptoList.add("BNBUSDT");
        CryptoList.add("BTCUSDT");
        parameters.put("symbol", "BNBUSDT");
        parameters.put("interval", "1m");
//        System.out.println(parameters);

        parameters.put("symbol", CryptoList);
        parameters.put("interval", "1d");
        System.out.println(parameters);
        System.out.println(parameters.get("symbol"));

        /*
        Get Klines
         */
        for (int i = 0; i < CryptoList.size(); i++) {
            parameters.put("symbol", CryptoList.get(i));
            parameters.put("interval", "1d");
            String result = spotClient.createMarket().klines(parameters);
            logger.info(result);
        }



    }
}