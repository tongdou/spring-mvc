package com.tongdou.serviceImpl.forum;

import com.tongdou.beans.bean.forum.Post;
import com.tongdou.beans.bean.forum.Topic;
import com.tongdou.service.forum.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by shenyuzhu on 2017/9/24.
 */

@ContextConfiguration(locations = {"classpath:/com/tongdou/dao/applicationContext.xml", "classpath:com/tongdou/service/forum/transactionProxyFactoryBean.xml"})
public class TransactionProxyFactoryBeanTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ForumService forumServiceProxy;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeClass
    public void initDatabase() {
        String createForum = "CREATE TABLE `forum` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";
        String createTopic = "CREATE TABLE `topic` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";
        String createPost = "CREATE TABLE `post` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";


        logger.info("start init database ");
        try {
            jdbcTemplate.execute(createForum);
            jdbcTemplate.execute(createTopic);
            jdbcTemplate.execute(createPost);
        } catch (Exception e) {
//            logger.error("init database error", e);
        }

        logger.info("end init database ");
    }

    @Test
    public void testTransactionProxyTopic() {
        // create topic
        Topic topic = new Topic();
        topic.setName("withoutTransaction006");

        // create post
        Post post1 = new Post();
        post1.setName("post006_1");

        Post post2 = new Post();
        post2.setName("post006_2");

        topic.getPostList().add(post1);
        topic.getPostList().add(post2);

        // save into database
        try {
            forumServiceProxy.addTransactionProxyTopic(topic);
        } catch (Exception e) {
            logger.error("forumServiceProxy.addTransactionProxyTopic");
        }

    }


}
