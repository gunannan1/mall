package com.seckill.userservice.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户信息
 */
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private String email;

    private String phone;

    private String salt;

    private String head;

    private String role;

    private Date createTime;

    private Date updateTime;

}
