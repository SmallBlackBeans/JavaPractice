package com.hanxiaocu.pojo;


/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/26 10:05 AM
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    long id;

    String name;

    Integer age;
}
