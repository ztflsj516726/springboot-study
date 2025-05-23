package com.ztf.back.controller;

import com.ztf.back.common.Res;
import com.ztf.back.model.dto.LoginDto;
import com.ztf.back.model.vo.LoginVo;
import com.ztf.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Res>  userLogin(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = userService.login(loginDto);
        if (loginVo != null) {
            return ResponseEntity.ok(Res.success(userService.login(loginDto)));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Res.error("账号或密码错误"));
        }
    }

    @GetMapping("hi")
    public Res Hi() {
        return Res.success("哈哈");
    }
}
