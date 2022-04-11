package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
public class User {
    private Integer id;
    private String username;
    private String password;
}
