package masterSpringMvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Aspire on 03.04.2017.
 */
@Configuration
@Profile("redis")
@EnableRedisHttpSession
public class RedisConfig {
//    @Autowired
//    public ObjectMapper objectMapper;

    @Bean(name = {"defaultRedisSerializer","springSessionDefaultRedisSerializer"})
    public RedisSerializer<Object> defaultRedisSerializer(){
        RedisSerializer result = new JdkSerializationRedisSerializer();
        return result;
    }
}
