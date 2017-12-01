package com.tongdou.mvc.service;

import com.tongdou.mvc.model.User;

/**
 * user service
 * Created by shenyuzhu on 2017/12/1.
 */
public interface UserService {
    /**
     * 校验用户名密码
     *
     * @return
     */
    boolean exist(User user);


    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    boolean register(User user);
}
