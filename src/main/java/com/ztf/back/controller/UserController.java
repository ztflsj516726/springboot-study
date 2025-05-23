package com.ztf.back.controller;

import com.ztf.back.common.Res;
import com.ztf.back.model.dto.LoginDto;
import com.ztf.back.model.vo.LoginVo;
import com.ztf.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:UserController
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/23-15:20
 * @Version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Res userLogin(@RequestBody LoginDto loginDto) {
        return Res.success(userService.login(loginDto));
    }

    @GetMapping("hi")
    public Res Hi() {
        return Res.success("哈哈");
    }
}
