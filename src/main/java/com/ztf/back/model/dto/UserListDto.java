package com.ztf.back.model.dto;

import lombok.Data;

/**
 * ClassName:UserListDto
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/29-11:56
 * @Version 1.0
 */
@Data
public class UserListDto {

    private Integer current = 1;

    private Integer pageSize = 10;
}
