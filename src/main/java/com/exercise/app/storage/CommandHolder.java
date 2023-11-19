package com.exercise.app.storage;

import com.exercise.app.model.ExecutableResults;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class CommandHolder {

    private final LoadingCache<UUID, ExecutableResults> holder = CacheBuilder.newBuilder()
            .concurrencyLevel(4).maximumSize(1000L).expireAfterWrite(24, TimeUnit.HOURS)
            .build(
                    new CacheLoader<UUID, ExecutableResults>() {
                        @Override
                        public ExecutableResults load(UUID uuid) throws Exception {
                            return new ExecutableResults(uuid.toString());
                        }
                    });

    public void store(UUID id, ExecutableResults results){holder.put(id,results);}

    public ExecutableResults getHoldedResults(UUID id){ return holder.getUnchecked(id);}
}
