package redis.demo.model.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author chenyuhan
 * Date 2021/7/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostArticle {
    private String title;
    private Long author;
}
