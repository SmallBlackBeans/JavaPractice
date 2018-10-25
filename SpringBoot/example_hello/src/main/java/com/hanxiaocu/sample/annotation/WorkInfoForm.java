package com.hanxiaocu.sample.annotation;

import com.hanxiaocu.sample.annotation.WorkOverTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 9:59 AM
 */
public class WorkInfoForm {

    @Size(min = 3, max = 20)
    String name;

    @Email
    String email;

    @WorkOverTime(max = 8)
    int workTime;

    //检验组
    public interface Update {
    }

    public interface Add {
    }

    //添加时必须为空
    //更新时id 必须不能为空
    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    Long id;
}


