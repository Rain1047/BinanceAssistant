package org.rainO_o;

import com.binance.connector.client.impl.SpotClientImpl;

import java.util.LinkedHashMap;

import org.rainO_o.config.SpringConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public final class Main {

    private Main() {

    }
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        System.out.println("Hello world!");

        /*
        add parameters --> spring
         */
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", "BNBUSDT");
        parameters.put("interval", "1m");
        System.out.println(parameters);
        parameters.put("symbol", "BTCUSDT");
        parameters.put("interval", "1d");
        System.out.println(parameters);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        /*
        client: create with spring
         */
//        SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
        SpotClientImpl spotClient = ctx.getBean(SpotClientImpl.class);


        /*
        Get Klines
         */
        String result = spotClient.createMarket().klines(parameters);

        logger.info(result);
    }
}