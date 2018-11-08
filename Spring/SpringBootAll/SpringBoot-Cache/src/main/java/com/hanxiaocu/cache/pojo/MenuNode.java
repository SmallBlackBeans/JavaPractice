package com.hanxiaocu.cache.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hanxiaocu.cache.entity.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 4:19 PM
 */
public class MenuNode implements Serializable {
    private Menu menu;

    private List<MenuNode> children = new ArrayList<MenuNode>();
    @JsonIgnore
    private MenuNode parent;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<MenuNode> getChildren() {
        return children;
    }

    public void setChildren(List<MenuNode> children) {
        this.children = children;
    }

    public MenuNode getParent() {
        return parent;
    }

    public void setParent(MenuNode parent) {
        this.parent = parent;
    }
}
