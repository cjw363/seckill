package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Classname SuccessKilledDaoTest
 * @Description
 * @Date 2020/6/18 0:30
 * @Created by cjw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Autowired
    SuccessKilledDao mSuccessKilledDao;

    @Test
    public void insertSuccessKilled() {
        long id=1000L;
        long phone=13888888888L;
        int insertCount = mSuccessKilledDao.insertSuccessKilled(id, phone);
        System.out.println(insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        SuccessKilled successKilled = mSuccessKilledDao.queryByIdWithSeckill(1000L, 13888888888L);
        System.out.println(successKilled.getSeckill().getName());
    }
}