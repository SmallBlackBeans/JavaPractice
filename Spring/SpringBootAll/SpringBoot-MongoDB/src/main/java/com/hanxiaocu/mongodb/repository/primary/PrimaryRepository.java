package com.hanxiaocu.mongodb.repository.primary;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:37 PM
 */
@Component
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject,String> {

}
