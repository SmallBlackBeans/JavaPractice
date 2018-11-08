package com.hanxiaocu.cache.service.impl;

import com.hanxiaocu.cache.entity.Menu;
import com.hanxiaocu.cache.pojo.MenuNode;
import com.hanxiaocu.cache.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 4:19 PM
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //当菜单改变后，需要把所有的菜单缓存失效，以便下次获取的时候重新构造
    @CacheEvict(cacheNames = {"menu","menuTree"},allEntries = true)
    public void addMenu(Menu menu) {

    }

    @Cacheable(cacheNames = "menu")
    public Menu getMenu(Long id) {
        logger.info("call service getMenu" + id);

        Menu menu = new Menu();
        menu.setId(id);
        menu.setName("菜单");
        menu.setParentId(1l);
        return menu;
    }

    @Cacheable(cacheNames = "menuTree")
    public MenuNode getMenuTree() {
        logger.info("call service getMenuTree");
        Menu root = new Menu();
        root.setCode("root");
        root.setId(1L);
        root.setName("系统管理");
        root.setParentId(null);

        Menu menu = new Menu();
        menu.setCode("menu");
        menu.setId(1L);
        menu.setName("菜单管理");
        menu.setParentId(1L);

        MenuNode tree = new MenuNode();
        tree.setMenu(root);
        tree.setParent(null);

        MenuNode menuTree = new MenuNode();
        menuTree.setMenu(menu);
        menuTree.setParent(tree);
        tree.getChildren().add(menuTree);

        return tree;
    }
}
