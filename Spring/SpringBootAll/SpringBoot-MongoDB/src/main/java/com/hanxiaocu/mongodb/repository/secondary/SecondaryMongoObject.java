package com.hanxiaocu.mongodb.repository.secondary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:38 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "secondary_mongo")
public class SecondaryMongoObject {

	@Id
	private Long id;
	private String value;

	@Override
	public String toString() {
		return "SecondaryMongoObject{" +
				"id=" + id +
				", value='" + value + '\'' +
				'}';
	}
}
