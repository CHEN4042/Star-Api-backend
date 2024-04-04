package com.star;

import com.star.starapiclientsdk.client.StarClient;
import com.star.starapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@SpringBootTest
class StarInterfaceApplicationTests {

    @Resource
    private StarClient starClient;

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        String cc1 = starClient.getNameByGet("cc");
        String cc = starClient.getNameByPost("cc");
        User user = new User();
        user.setUsername("asc");
        String nameByPostWithJson = starClient.getNameByPostWithJson(user);
        System.out.println(cc);
        System.out.println(cc1);
        System.out.println(nameByPostWithJson);
    }

}
