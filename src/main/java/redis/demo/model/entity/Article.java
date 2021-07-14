package redis.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Author chenyuhan
 * Date 2021/7/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Long author;
    private Long articleId;
    private String title;
    private Long createTime;
    private Long votes;
    private Long score;


    public Map<String, Object> buildMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("author",author);
        map.put("articleId",articleId);
        map.put("title",title);
        map.put("createTime",createTime);
        map.put("votes",votes);
        map.put("score",score);
        return map;
    }
}
