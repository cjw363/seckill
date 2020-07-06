package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.excepetion.RepeatKillException;
import org.seckill.excepetion.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Classname SeckillServiceTest
 * @Description
 * @Date 2020/6/28 23:35
 * @Created by cjw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("list={}", seckillList);
    }

    @Test
    public void getById() {
        Seckill seckill = seckillService.getById(1000);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() {
        Exposer exposer = seckillService.exportSeckillUrl(1000);
        logger.info("exposer={}", exposer);
    }

    @Test
    public void executeSeckill() {
        try {
            long id = 1000;
            long phone = 18888888888L;
            String md5 = "0c7ffba1e60cf1c66c690dbb345bb04a";
            SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
            logger.info("seckillExecution={}", seckillExecution);
        } catch (SeckillCloseException | RepeatKillException e) {
            logger.info("Exception={}", e.getMessage());
        }
    }

    @Test
    public void executeSeckillLogic() {
        long id = 1000;
        long phone = 18888888888L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            try {

                String md5 = exposer.getMd5();
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                logger.info("seckillExecution={}", seckillExecution);
            } catch (SeckillCloseException | RepeatKillException e) {
                logger.info("Exception={}", e.getMessage());
            }
        } else
            logger.info("Exception={}", exposer);//秒杀未开启
    }

    @Test
    public void executeSeckillProcedure() {
        long id = 1002;
        long phone = 18888888888L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            try {
                String md5 = exposer.getMd5();
                SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(id, phone, md5);
                logger.info("seckillExecution={}", seckillExecution);
            } catch (SeckillCloseException | RepeatKillException e) {
                logger.info("Exception={}", e.getMessage());
            }
        } else
            logger.info("Exception={}", exposer);//秒杀未开启

    }
}