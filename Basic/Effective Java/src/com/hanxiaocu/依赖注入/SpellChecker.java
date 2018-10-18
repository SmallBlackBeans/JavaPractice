package com.hanxiaocu.依赖注入;

import java.util.Dictionary;
import java.util.function.Supplier;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/18 3:41 PM
 */
public class SpellChecker {

    private final Dictionary dictionary;

    //对于资源应该从外界传入
    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    //或者传入一个工厂类
    public void create(Supplier<? extends Dictionary> tileFactory) {

    }
}
