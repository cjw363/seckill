package org.seckill.excepetion;

/**
 * 秒杀关闭异常（）
 * @Classname SeckillCloseException
 * @Description
 * @Date 2020/6/27 17:59
 * @Created by cjw
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
