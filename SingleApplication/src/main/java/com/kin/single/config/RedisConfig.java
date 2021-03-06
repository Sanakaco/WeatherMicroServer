package com.kin.single.config;


import com.kin.single.city.CityMsg;
import com.kin.single.weather.WeatherResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author pandas
 * @ClassName RedisConfig
 * @Description TODO
 * @create 2019/11/21 10:42
 */
@Configuration
public class RedisConfig {
    /**
     *@Method redisTemplate
     *@Description redis自定义缓存配置，
     *@author pandas
     *@create 2019/11/20 21:13
     *@Param [factory]
     *@return org.springframework.data.redis.core.RedisTemplate<java.lang.String,com.kin.single.weather.WeatherResponse>
     */
    @Bean
    public RedisTemplate<String, WeatherResponse> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,WeatherResponse> template=new RedisTemplate<String, WeatherResponse>();

        //实例化JackSon的序列化器，将value自定义为对象
        Jackson2JsonRedisSerializer<WeatherResponse> serializer=new Jackson2JsonRedisSerializer<WeatherResponse>(WeatherResponse.class);
        //设置key的序列化为string
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        //设置value的序列化为自定义对象
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);

        //设置redis连接工厂
        template.setConnectionFactory(factory);
        return template;

    }

    @Bean
    public RedisTemplate<String, CityMsg> redisTemplateForCity(RedisConnectionFactory factory){
        RedisTemplate<String,CityMsg> template=new RedisTemplate<String, CityMsg>();
        Jackson2JsonRedisSerializer<CityMsg> serializer=new Jackson2JsonRedisSerializer<CityMsg>(CityMsg.class);

        template.setConnectionFactory(factory);

        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);

        return template;
    }
}
