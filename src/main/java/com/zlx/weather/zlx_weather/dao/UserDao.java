package com.zlx.weather.zlx_weather.dao;

import com.zlx.weather.zlx_weather.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: 郑立轩
 * @since: 2020/6/20
 * create at : 2020/6/20 10:33
 */
@Mapper
public interface UserDao {

    @Select("select * from user where deleted=0")
    List<User> selectWeatherUser();

    @Select("select city from user where deleted=0 group by city")
    List<String> selectCity();

}
