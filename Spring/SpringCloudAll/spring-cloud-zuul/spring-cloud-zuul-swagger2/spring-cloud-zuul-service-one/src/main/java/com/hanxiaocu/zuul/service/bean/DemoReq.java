package com.hanxiaocu.zuul.service.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc: 请求实体
 * @author: hanchenghai
 * @date: 2018/11/12 3:53 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class DemoReq {
	@ApiModelProperty(name="code",value="编码",example="BBS")
	String code;

	@ApiModelProperty(name="name",value="名称",example="韩小醋")
	String name;

	@ApiModelProperty(name="remark",value="备注",example="github:SmallBlackBeans")
	String remark;
}
