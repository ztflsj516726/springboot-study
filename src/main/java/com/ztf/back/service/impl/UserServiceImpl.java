package com.ztf.back.service.impl;

import com.ztf.back.mapper.UserMapper;
import com.ztf.back.model.dto.LoginDto;
import com.ztf.back.model.entity.User;
import com.ztf.back.model.vo.LoginVo;
import com.ztf.back.service.UserService;
import com.ztf.back.util.JwtUtil;
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
    private  JwtUtil jwtUtil;

    @Override
    public LoginVo login(LoginDto loginDto) {
        User user = userMapper.login(loginDto);
        if (user != null) {
            String token =jwtUtil.setToekn(user.getId().toString());
            LoginVo loginVo = LoginVo.builder()
                    .id(user.getId())
                    .token(token)
                    .username(user.getUsername())
                    .build();
            return loginVo;
        } else {
            return null;
        }
    }
}
