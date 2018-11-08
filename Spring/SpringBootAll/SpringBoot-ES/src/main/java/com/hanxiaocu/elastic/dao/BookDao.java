package com.hanxiaocu.elastic.dao;

import com.hanxiaocu.elastic.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 3:35 PM
 */
public interface BookDao extends CrudRepository<BookEntity,String> {
    public List<BookEntity> getByMessage(String message);
    public List<BookEntity> getByMessageAAndType(String message,String type);
    public Page<BookEntity> getByMessage(String message, Pageable pageable);
}
