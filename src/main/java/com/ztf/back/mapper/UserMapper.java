package com.ztf.back.mapper;

import com.ztf.back.model.dto.LoginDto;
import com.ztf.back.model.dto.RegDto;
import com.ztf.back.model.dto.UserListDto;
import com.ztf.back.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @Insert("insert into  users (username,password) values (#{username},#{password})")
    // 自增 自动给user的id赋值
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long register(User user);

    @Select("select count(*) from users where username = #{username}")
    int existUsername(String username);

    @Select("select * from users where  id = #{userId} limit 1")
    User getUserInfo(String userId);

    @Update("update users set username= #{username}, email= #{email}, phone= #{phone}, avatar= #{avatar}, status= #{status} where id = #{id}")
    int UpdateUserInfo(User user);

    List<User> userList();

}
