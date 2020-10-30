package com.eujian.rabbitmqtrace.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserInfo implements Serializable {

    private Integer id;

    private String name;
}
