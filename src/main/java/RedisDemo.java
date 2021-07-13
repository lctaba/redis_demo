import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Author chenyuhan
 * Date 2021/7/13
 */
@EnableCaching
@SpringBootApplication
public class RedisDemo {
    public static void main(String[] args) {
        SpringApplication.run(RedisDemo.class,args);
    }
}
