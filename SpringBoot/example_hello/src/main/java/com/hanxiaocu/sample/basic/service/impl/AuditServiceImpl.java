package com.hanxiaocu.sample.basic.service.impl;

import com.hanxiaocu.sample.basic.service.AuditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 2:38 PM
 */
@Service
/**
 * 一个事务中一个服务又调用了这个服务
 * 默认是所有的调用处于同一个事务上下文中
 * REQUIRES_NEW 开一个新的事务上下文，
 * 这样做是保证一些必须的操作，不管成功不成功都需要记录的操作。
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AuditServiceImpl implements AuditService {

}


