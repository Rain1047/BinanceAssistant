package org.rainO_o.config;

import com.binance.connector.client.impl.SpotClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.rainO_o")
public class SpringConfig {
//    public DataSource dataSource(){
//        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
//        ds.setUsername("root");
//        ds.setPassword("root");
//        return ds;
//    }
    @Bean
    public SpotClientImpl spotClient(){
        SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
        return client;
    }


}
