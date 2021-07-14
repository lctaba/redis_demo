package redis.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author chenyuhan
 * Date 2021/7/14
 */
@RestController
public class ArticleController {
    @GetMapping("app")
    public String getApp(){
        return "redis-demo";
    }
}
