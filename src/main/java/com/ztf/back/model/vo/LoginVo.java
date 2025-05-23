package com.ztf.back.model.vo;

import lombok.Builder;
import lombok.Data;

/**
 * ClassName:LoginVo
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/23-15:23
 * @Version 1.0
 */
@Data
@Builder
public class LoginVo {

    private Long id;

    private String username;

    private String token;


}
