package com.zlx.weather.zlx_weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZlxWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZlxWeatherApplication.class, args);
    }

}
