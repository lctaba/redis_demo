package redis.demo.service;

import org.springframework.stereotype.Service;
import redis.demo.dao.RedisOptionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import redis.demo.model.entity.Article;
import redis.demo.model.post.PostArticle;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Author chenyuhan
 * Date 2021/7/14
 */
@Service
public class ArticleService {
    private static final String ARTICLE_ID = "articleId";
    private static final String ARTICLE_SET_KEY = "article";
    private static final String ARTICLE_TIME_KEY = "article_time";
    private static final String ARTICLE_SCORE_KEY = "article_score";

    @Autowired
    private RedisOptionImpl redisOption;

    @PostConstruct
    private void initId(){
        if(redisOption.get(ARTICLE_ID) == null) {
            redisOption.set(ARTICLE_ID, 0L);
        }
    }

    public Map<String,Object> postArticle(PostArticle postArticle){
        if(postArticle.getTitle() != null && postArticle.getAuthor() != null) {
            Article article = new Article();
            article.setTitle(postArticle.getTitle());
            article.setAuthor(postArticle.getAuthor());
            long now = System.currentTimeMillis();
            article.setCreateTime(now);
            article.setVotes(1L);
            Long articleId = redisOption.incr(ARTICLE_ID, 1L);
            article.setArticleId(articleId);
            article.setScore(now / 1000 + 432);
            if(redisOption.hHasKey(ARTICLE_SET_KEY, articleId.toString())
                    || redisOption.zsIsMember(ARTICLE_SCORE_KEY, articleId.toString())
                    || redisOption.zsIsMember(ARTICLE_TIME_KEY, articleId.toString())) {
                return new HashMap<>();
            }
            redisOption.hSet(ARTICLE_SET_KEY, articleId.toString(), article);
            redisOption.zsAdd(ARTICLE_SCORE_KEY, articleId.toString(), article.getScore());
            redisOption.zsAdd(ARTICLE_TIME_KEY, articleId.toString(), now);
            return article.buildMap();
        } else {
            return new HashMap<>();
        }
    }
}
