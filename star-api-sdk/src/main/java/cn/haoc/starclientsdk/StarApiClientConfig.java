package cn.haoc.starclientsdk;

import cn.haoc.starclientsdk.client.StarApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Star API 客户端配置类
 */
@Data
@Configuration
@ConfigurationProperties("star.client")
@ComponentScan
public class StarApiClientConfig {

    private String accessKey;

    private String secretKey;

    /**
     * 此处方法取名无所谓的，不影响任何地方
     *
     * @return NeroApiClient
     */
    @Bean
    public StarApiClient getApiClient() {
        return new StarApiClient(accessKey, secretKey);
    }
}
