package org.seckill.excepetion;

/**
 * 重复秒杀异常（运行期异常）
 * @Classname RepeatKillException
 * @Description
 * @Date 2020/6/27 17:58
 * @Created by cjw
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
