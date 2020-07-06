package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 * @Classname SeckillDaoTest
 * @Description
 * @Date 2020/6/18 0:07
 * @Created by cjw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    @Autowired
    SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        int i = seckillDao.reduceNumber(1000, new Date());
        System.out.println(i);
    }

    @Test
    public void queryById() {
        Seckill seckill = seckillDao.queryById(1000);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        System.out.println(seckills.get(0));
    }
}