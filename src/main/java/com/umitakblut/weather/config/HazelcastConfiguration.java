package com.umitakblut.weather.config;


import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class HazelcastConfiguration {
    @Bean
    public CacheManager cacheManager(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        return new com.hazelcast.spring.cache.HazelcastCacheManager(hazelcastInstance);
    }

    @Bean(value = "hazelcastInstance")
    public HazelcastInstance hazelcastInstance () {
        HazelcastInstance hazelcastInstance = Hazelcast.getHazelcastInstanceByName("weather-hazelcast");
        if (hazelcastInstance != null) {
            return hazelcastInstance;
        }

        Config hazelcastConfig = new Config();
        hazelcastConfig.setInstanceName("weather-hazelcast");
        hazelcastConfig.getNetworkConfig().setPort(5701);
        return Hazelcast.newHazelcastInstance(hazelcastConfig);
    }
}
