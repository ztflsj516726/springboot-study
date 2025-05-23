package com.ztf.back.model.entity;

/**
 * ClassName:User
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/23-14:38
 * @Version 1.0
 */

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class User {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String avatar;

    private Integer status = 1;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
