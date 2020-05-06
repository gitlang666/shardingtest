package com.lsx.shardingtest.config;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Integer> preciseShardingValue) {
        //是根据id取模4来获取表名的
        for (String tableName : collection) {
            if (tableName.endsWith(preciseShardingValue.getValue() % 4 + "")) {
                System.out.println("tablename="+tableName+",preciseShardingValue="+preciseShardingValue.getValue());
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}
