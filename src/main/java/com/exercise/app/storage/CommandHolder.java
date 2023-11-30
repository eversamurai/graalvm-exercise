package com.exercise.app.storage;

import org.springframework.stereotype.Component;

@Component
public class CommandHolder {

  /*  private final LoadingCache<UUID, ExecutableResults> holder = CacheBuilder.newBuilder()
            .concurrencyLevel(4).maximumSize(1000L).expireAfterWrite(24, TimeUnit.HOURS)
            .build(
                    new CacheLoader<UUID, ExecutableResults>() {
                        @Override
                        public ExecutableResults load(UUID uuid) throws Exception {
                            return new ExecutableResults(uuid.toString());
                        }
                    });*/

   // public void store(UUID id, ExecutableResults results){holder.put(id,results);}

   // public ExecutableResults getHoldedResults(UUID id){ return holder.getUnchecked(id);}
}
