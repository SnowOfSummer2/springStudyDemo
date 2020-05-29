package com.betterchengpu.IImpl;

import com.betterchengpu.model.TestTable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface SpitterRepository {
    @CachePut(value = "sptterCache",key="#result.keyId")
    TestTable addSpitter(TestTable tb);

    @Cacheable(value = "sptterCache")
    TestTable findOne(String keyId);
}
