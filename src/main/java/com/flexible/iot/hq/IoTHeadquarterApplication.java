package com.flexible.iot.hq;

import com.flexible.iot.hq.config.FileStorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageConfig.class
})
public class IoTHeadquarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(IoTHeadquarterApplication.class, args);
    }

}
