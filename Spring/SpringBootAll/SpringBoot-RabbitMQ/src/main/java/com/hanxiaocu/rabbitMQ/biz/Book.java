package com.hanxiaocu.rabbitMQ.biz;

import java.io.Serializable;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20 9:40 AM
 */

public class Book implements Serializable {
	private static final long serialVersionUID = -774955729677386378L;


	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
