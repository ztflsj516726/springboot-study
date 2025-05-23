package com.ztf.back.mapper;

import com.ztf.back.model.dto.LoginDto;
import com.ztf.back.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName:UserMapper
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/23-14:56
 * @Version 1.0
 */

@Mapper
public interface UserMapper {
    @Select("select * from users where username=#{username} and password = #{password}")
    User login(LoginDto loginDto);
}
