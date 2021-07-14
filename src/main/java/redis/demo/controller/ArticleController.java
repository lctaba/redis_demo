package redis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import redis.demo.model.post.PostArticle;
import redis.demo.service.ArticleService;

import java.util.Map;

/**
 * Author chenyuhan
 * Date 2021/7/14
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("app")
    public String getApp(){
        return "redis-demo";
    }


    @PostMapping("article")
    public Map<String, Object> postArticle(@RequestBody PostArticle postArticle){
        return articleService.postArticle(postArticle);
    }
}
