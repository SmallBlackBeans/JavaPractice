package com.hanxiaocu.webapp.dateformat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/21
 */
public class Order {


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime payTime;
}
