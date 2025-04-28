package com.tektonlabs.percentagecalculationapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheServiceTest {

    private ConcurrentMapCacheManager cacheManager;

    @BeforeEach
    public void setUp() {
        cacheManager = new ConcurrentMapCacheManager("percentageCache");
    }

    @Test
    public void testCache() {
        Cache cache = cacheManager.getCache("percentageCache");
        assert cache != null;
        cache.put("percentage", 10.0);

        // Recupera el valor de la caché
        double cachedValue = cache.get("percentage", Double.class);

        // Verifica que el valor sea el esperado
        assertEquals(10.0, cachedValue);
    }
}
