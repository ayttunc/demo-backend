package com.flexible.iot.hq;

import com.flexible.iot.hq.config.FileStorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageConfig.class
})
public class IoTHeadquarterApplication {

    /**
     * Spring security de bir sorun mu var nedir bilmiyorum bir türlü güvenlik kısmı düzgün çalışmadı.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(IoTHeadquarterApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
