package org.seckill.excepetion;

/**
 * @Classname SeckillException
 * @Description
 * @Date 2020/6/27 18:00
 * @Created by cjw
 */
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
