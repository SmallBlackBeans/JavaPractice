package com.hanxiaocu.webservice.dto;

import com.hanxiaocu.webservice.pojo.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/13 2:13 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

	String name;

	List<String> hobby;

	String birthday;

	String description;

	Sex sex;

}
