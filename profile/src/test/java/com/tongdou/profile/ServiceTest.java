package com.tongdou.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by shenyuzhu on 2017/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ac.xml")
public class ServiceTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ProfileService profileService;

    @Test
    public void testSayHello() {
        logger.info("======start");
        profileService.sayHello();
        logger.info("======end");

    }


}