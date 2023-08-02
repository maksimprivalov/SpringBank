package com.maksimprivalov.springbank;


import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {
    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, BigDecimal.TEN));

    public BigDecimal getBalanceForId(Long accoutnId) {
        return storage.get(accoutnId);
    }

    public void save(Long id, BigDecimal amount) {
storage.put(id, amount);
    }
}
