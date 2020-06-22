package com.zlx.weather.zlx_weather.controller;

import com.zlx.weather.zlx_weather.dto.User;
import com.zlx.weather.zlx_weather.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
@Slf4j
public class MessageController {
    @Autowired
    private MessageService messageService;


    @RequestMapping(value = "/sendMessage",method = RequestMethod.POST)
    @ResponseBody
    public Boolean sendMessage() {
        Boolean result = false;
        log.debug("定时任务开始运行");
      List<User>list = messageService.searchUser();
        return null;
    }


}
