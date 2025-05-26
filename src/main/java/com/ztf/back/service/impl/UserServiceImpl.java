package com.ztf.back.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.ztf.back.common.UserContext;
import com.ztf.back.exception.HandleException;
import com.ztf.back.mapper.UserMapper;
import com.ztf.back.model.dto.LoginDto;
import com.ztf.back.model.dto.RegDto;
import com.ztf.back.model.entity.User;
import com.ztf.back.model.vo.LoginVo;
import com.ztf.back.service.UserService;
import com.ztf.back.util.JwtUtil;
import com.ztf.back.util.Md5Util;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/23-15:14
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public LoginVo login(LoginDto loginDto) {
        if (StringUtils.isEmpty(loginDto.getUsername())) {
            throw new HandleException("用户名不能为空");
        }
        if (StringUtils.isEmpty(loginDto.getPassword())) {
            throw new HandleException("密码不能为空");
        }

        loginDto.setPassword(Md5Util.encryptPassword(loginDto.getPassword()));
        User user = userMapper.login(loginDto);
        if (user.getStatus() != 1) {
            throw new HandleException("该用户被禁用");
        }
        String token = jwtUtil.setToekn(user.getId().toString());
        return LoginVo.builder().id(user.getId()).token(token).username(user.getUsername()).build();
    }

    @Override
    public User register(RegDto regDto) {
        if (StringUtils.isEmpty(regDto.getUsername())) {
            throw new HandleException("用户名不能为空");
        }
        if (StringUtils.isEmpty(regDto.getPassword())) {
            throw new HandleException("密码不能为空");
        }
        if (userMapper.existUsername(regDto.getUsername()) > 0) {
            throw new HandleException("用户名已存在");
        }

        User user = User.builder().username(regDto.getUsername()).password(Md5Util.encryptPassword((regDto.getPassword()))).build();
        System.out.println("user" + user);
        Long id = userMapper.register(user);
        user.setId(id);
        return user;
    }

    @Override
    public User getUserInfo() {
        User user = userMapper.getUserInfo(UserContext.getUserId());
        if (user == null) {
            throw new HandleException("未查询到该用户");
        }
        return user;
    }

    @Override
    public Boolean updateUserInfo(User user) {
        user.setId(Long.parseLong(UserContext.getUserId()));
        return userMapper.UpdateUserInfo(user) > 0;
    }
}
