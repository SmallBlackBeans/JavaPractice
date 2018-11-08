package com.hanxiaocu.sample.basic.service;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 10:25 AM
 */

public interface CreditUserService {

    public int getUserCredit(int userId);

    public boolean addCedit(int userId, int score);

}
