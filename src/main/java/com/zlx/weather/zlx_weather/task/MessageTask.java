package com.zlx.weather.zlx_weather.task;

import com.zlx.weather.zlx_weather.dto.User;
import com.zlx.weather.zlx_weather.dto.Weather;
import com.zlx.weather.zlx_weather.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

@Component
@EnableScheduling
public class MessageTask {
    @Autowired
    private MessageService messageService;
    private static final Logger LOG = LoggerFactory.getLogger(MessageTask.class);

    @Scheduled(fixedRate = 6 * 60 * 60 * 1000)
    public void sendMessage() {
        LOG.debug("定时任务开始运行");
        //存储city 的map
        HashMap<String, String> weatherMap = new HashMap<>(10);
        //先查所有city
        List<String> cityList = messageService.selectCity();
        if (!CollectionUtils.isEmpty(cityList)) {
            for (String cityName : cityList) {
                Weather weather = messageService.getWeather(cityName);
                weatherMap.put(cityName, weather.getWea());

            }
        }

        List<User> userList = messageService.searchUser();
        LOG.debug("查询到的USER=》" + userList);
        if (!CollectionUtils.isEmpty(userList)) {
            for (User user : userList) {
            String userCity = user.getCity();
            String weather = weatherMap.get(userCity);
            if (weather.contains("雨")) {
                messageService.sendSimpleMessage(user.getPhone());
            }

            }
        }
    }


}
