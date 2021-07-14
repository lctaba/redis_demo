package redis.demo.service;

import redis.demo.dao.RedisOptionImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author chenyuhan
 * Date 2021/7/14
 */
public class ArticleService {
    @Autowired
    private RedisOptionImpl redisOption;

}
