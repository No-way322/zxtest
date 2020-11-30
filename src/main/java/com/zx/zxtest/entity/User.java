package com.zx.zxtest.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Integer id;
    private String name;
    private String desc;
    private Integer pid;
    private Integer nodeSign;
    private List<User> childrenList;

}
