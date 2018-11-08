package com.hanxiaocu.sample.basic.controller;

import com.hanxiaocu.sample.annotation.WorkInfoForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 10:04 AM
 */
@Controller
public class ValidatedController {


    @ResponseBody
    @RequestMapping("/addworkInfo.html")
    //检验结果放在BindingResult中
    public void addWorkInfo(@Validated({WorkInfoForm.Add.class}) WorkInfoForm workInfo, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError) list.get(0);
            System.out.println(error.getObjectName() + "," + error.getField() + "," + error.getDefaultMessage());
            return;
        }
        return;
    }

}
