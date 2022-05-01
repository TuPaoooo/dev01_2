package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    private Integer typeId;
    //分类
    private String groupName;
    //总数
    private Integer noteCount;
}
