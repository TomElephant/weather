package com.zlx.weather.zlx_weather.service;

import com.zlx.weather.zlx_weather.dto.User;
import com.zlx.weather.zlx_weather.dto.Weather;

import java.util.List;

public interface MessageService {
    boolean sendSimpleMessage(String phone);

    Weather getWeather(String city);

    List<User> searchUser();

    List<String> selectCity();
}