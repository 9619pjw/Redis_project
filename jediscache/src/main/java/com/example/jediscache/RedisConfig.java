package com.example.jediscache;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Component
public class RedisConfig {
    // JedisPool 정보를 Bean에 등록해서 사용
    @Bean
    public JedisPool createJedisPool(){
        return new JedisPool("127.0.0.1", 6369);
    }
}
