package com.ztf.back.service;

import com.github.pagehelper.PageInfo;
import com.ztf.back.model.dto.LoginDto;
import com.ztf.back.model.dto.RegDto;
import com.ztf.back.model.dto.UserListDto;
import com.ztf.back.model.entity.User;
import com.ztf.back.model.vo.LoginVo;
import com.ztf.back.util.PageInfoResult;

import java.util.List;

/**
 * ClassName:UserService
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/23-15:04
 * @Version 1.0
 */
public interface UserService {
    LoginVo login(LoginDto loginDto);

    User register(RegDto regDto);

    User getUserInfo();

    Boolean updateUserInfo(User user);

    PageInfoResult<User> getUserList(UserListDto userListDto);

}
