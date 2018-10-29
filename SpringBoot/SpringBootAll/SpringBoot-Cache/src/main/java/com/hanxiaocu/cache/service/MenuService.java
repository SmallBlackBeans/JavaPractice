package com.hanxiaocu.cache.service;

import com.hanxiaocu.cache.entity.Menu;
import com.hanxiaocu.cache.pojo.MenuNode;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 4:17 PM
 */
public interface MenuService {
    public void addMenu(Menu menu);
    public Menu getMenu(Long id);
    public MenuNode getMenuTree();
}
