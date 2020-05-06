package com.lsx.shardingtest.config;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;

import java.util.Collection;

public class MyDataBasesPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        //是根据id取模2来获取表名的
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(shardingValue.getValue() % 2 + "")) {
                System.out.println("tablename="+tableName+",preciseShardingValue="+shardingValue.getValue());
                return tableName;
            }
        }

        throw new IllegalArgumentException();
    }
}
