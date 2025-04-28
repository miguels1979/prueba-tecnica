package com.tektonlabs.percentagecalculationapi.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@Configuration
@EnableCaching
public class CacheConfig {

    private static final long EXPIRATION_MINUTES = 30;

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ConcurrentMapCache percentageCache = new ConcurrentMapCache(
                "percentageCache",
                new ExpiringMap<>(EXPIRATION_MINUTES),
                false
        );
        cacheManager.setCaches(List.of(percentageCache));
        return cacheManager;
    }

    static class ExpiringMap<K, V> extends ConcurrentHashMap<K, V> {
        private final long expirationTimeMillis;
        private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        ExpiringMap(long expirationInMinutes) {
            super();
            this.expirationTimeMillis = expirationInMinutes * 60 * 1000;
            startCleanupTask();
        }

        private void startCleanupTask() {

        }
    }
}
