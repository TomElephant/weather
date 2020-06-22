package com.zlx.weather.zlx_weather.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.zlx.weather.zlx_weather.dao.UserDao;
import com.zlx.weather.zlx_weather.dto.User;
import com.zlx.weather.zlx_weather.dto.Weather;
import com.zlx.weather.zlx_weather.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 郑立轩
 * @since: 2020/6/16
 * create at : 2020/6/16 22:34
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private UserDao userDao;
    private static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

    private static final String APPID = "49392131";
    private static final String APPSECRET  = "wErzthl3";
    private static final String ACCESSKEY = "LTAIqCZeH17zxYLO";
    private static final String SECRET = "nzgj4Xe1oCtbULFVHEwHpWz0MEurPg";
    @Override
    public boolean sendSimpleMessage(String phone) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESSKEY, SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "彩虹城");
        request.putQueryParameter("TemplateCode", "SMS_193247858");
        request.putQueryParameter("TemplateParam", "{\"name\":\"轩轩宝贝\"}");

        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println(response.getData());

        return false;
    }

    @Override
    public Weather getWeather(String  city) {
        HttpRequest httpRequest = HttpUtil.createGet("https://www.tianqiapi.com/api?version=v6&" + "appid=" + APPID + "&appsecret=" +APPSECRET + "&city="+city);
        String res = httpRequest.execute().body();
        Weather weather = JSON.parseObject(res, Weather.class);
        return weather;

    }

    @Override
    public List<User> searchUser() {
      return userDao.selectWeatherUser();

    }

    @Override
    public List<String> selectCity() {

        return userDao.selectCity();
    }


}
