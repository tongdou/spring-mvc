package com.tongdou.profile.impl;

import com.tongdou.profile.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shenyuzhu on 2017/12/9.
 */
@Component
public class ProfileServiceImpl implements ProfileService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${config.name}")
    private String name;

    @Override
    public void sayHello() {
        logger.info("name:{}", name);
    }
}
