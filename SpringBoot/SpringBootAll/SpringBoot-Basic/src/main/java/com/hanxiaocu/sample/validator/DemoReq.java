package com.hanxiaocu.sample.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 5:08 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoReq {

    @NotBlank(message = "code 不能为空")
    String code;

    @Length(max = 10,message = "name 长度不能超过10")
    String name;

}
