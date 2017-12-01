package com.tongdou.mvc.service.impl;

import com.tongdou.mvc.model.User;
import com.tongdou.mvc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenyuzhu on 2017/12/1.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 模拟数据库，存储注册的用户
     */
    private static List<User> USER_DB = new ArrayList<>();

    @Override
    public boolean exist(User user) {
        for (User u : USER_DB) {
            if (StringUtils.equals(u.getUserName(), user.getUserName())) {
                return true;
            }
        }

        USER_DB.add(user);
        return false;
    }

    @Override
    public boolean register(User user) {
        return USER_DB.add(user);
    }


}
