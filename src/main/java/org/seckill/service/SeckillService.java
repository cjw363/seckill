package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.excepetion.RepeatKillException;
import org.seckill.excepetion.SeckillCloseException;
import org.seckill.excepetion.SeckillException;

import java.util.List;

/**
 * 业务接口：站在 “使用者” 角度设计接口
 * 三个方面：
 *
 * 方法定义粒度 （不应该关注怎么实现）
 * 参数（简练 不应该map）
 * 返回类型/异常（不应该map）
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录/秒杀产品列表
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启是输出秒杀接口地址，否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
    throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
     * 执行秒杀通过存储过程
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5)
      throws SeckillException, RepeatKillException, SeckillCloseException;
}
