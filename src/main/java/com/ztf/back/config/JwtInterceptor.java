package com.ztf.back.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztf.back.common.Res;
import com.ztf.back.common.UserContext;
import com.ztf.back.exception.HandleException;
import com.ztf.back.mapper.UserMapper;
import com.ztf.back.model.entity.User;
import com.ztf.back.service.UserService;
import com.ztf.back.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String token = request.getHeader("Authorization"); // 前端请求头中带的 token

        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(Res.notLogin("用户未登录"));
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);
            return false;
        }


        try {
            String id = jwtUtil.parseToken(token); // 验证 + 解析
            UserContext.setUserId(id);
            User user = userMapper.getUserInfo(id);
            if (user.getStatus() != 1) {
                throw new HandleException("用户被禁用");
            }
            return true; // 放行

        } catch (HandleException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 禁止
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(Res.notLogin("用户被禁止"));
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);
            return false;

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(Res.notLogin("用户登录信息失效"));
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);
            return false;
        }
    }
}
