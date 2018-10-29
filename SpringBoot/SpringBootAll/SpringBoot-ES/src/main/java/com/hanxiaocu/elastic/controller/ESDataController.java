package com.hanxiaocu.elastic.controller;

import com.hanxiaocu.elastic.dao.BookDao;
import com.hanxiaocu.elastic.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 3:39 PM
 */
@RestController
public class ESDataController {

    @Autowired
    BookDao dao;
    
    @RequestMapping("/springdata/book/{id}")
    public BookEntity getBookById(@PathVariable String id){
        Optional<BookEntity> opt = dao.findById(id);
        BookEntity           book = opt.get();
        return book;
    }

    @RequestMapping("/springdata/search/{key}")
    public List<BookEntity> search(@PathVariable String key) {
        //全文搜索
        List<BookEntity> list = dao.getByMessage(key);
        return list;
    }


    @RequestMapping("/springdata/book/search/{key}/{page}")
    public List<BookEntity> search(@PathVariable int page,@PathVariable String key) {
        int numberOfPage = 5;
        PageRequest request = PageRequest.of(page,numberOfPage);
        Page<BookEntity> pages = dao.getByMessage(key, request);
        long total = pages.getTotalElements();
        long totalPage = pages.getTotalPages();
        List<BookEntity> list = pages.getContent();
        return list;
    }

}
