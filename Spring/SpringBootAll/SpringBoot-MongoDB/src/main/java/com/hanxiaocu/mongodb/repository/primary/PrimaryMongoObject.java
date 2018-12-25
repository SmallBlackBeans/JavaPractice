package com.hanxiaocu.mongodb.repository.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:35 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "primaty_mongo")
public class PrimaryMongoObject {

	@Id
	private String id;
	private String value;

	@Override
	public String toString() {
		return "PrimaryMongoObject{" +
				"id='" + id + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}
