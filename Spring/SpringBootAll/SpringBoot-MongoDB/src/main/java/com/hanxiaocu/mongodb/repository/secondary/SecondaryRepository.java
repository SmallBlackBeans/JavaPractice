package com.hanxiaocu.mongodb.repository.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:39 PM
 */
@Component
public interface SecondaryRepository extends MongoRepository<SecondaryMongoObject, Long> {
}
