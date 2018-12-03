package com.hanxiaocu.auditlog.utils;

import com.alibaba.fastjson.serializer.SerializeFilter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/03 5:02 PM
 */
public class FastjsonFilterUtil implements SerializeFilter {

	private List<String> excludes = new ArrayList<>();
	private List<String> includes = new ArrayList<>();

	public List getExcludes() {
		return excludes;
	}

	public List getIncludes() {
		return this.includes;
	}
}
