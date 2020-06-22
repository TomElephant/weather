package com.zlx.weather.zlx_weather.dto;

import lombok.Data;

/**
 * @author: 郑立轩
 * @since: 2020/6/20
 * create at : 2020/6/20 10:34
 */
@Data
public class User {
    private String phone;
    private Boolean deleted;
    private String city;
}
