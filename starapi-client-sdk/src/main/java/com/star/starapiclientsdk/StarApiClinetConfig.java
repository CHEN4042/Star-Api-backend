package com.star.starapiclientsdk;

import com.star.starapiclientsdk.client.StarClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("starapi.client")
@Data
@ComponentScan
public class StarApiClinetConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public StarClient starApiClinet(){
       return new StarClient(accessKey,secretKey);
    }

}
