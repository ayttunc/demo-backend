package com.cmvtech.news.cmvnews;

import com.cmvtech.news.cmvnews.config.FileStorageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageConfig.class
})
public class CmvNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmvNewsApplication.class, args);
    }

}
