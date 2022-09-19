package com.cleancode.houseutils.policy;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author ggmd
 * 임대차일때 중개수수료 계산해주는 클래스
 * **/
@Getter
public class RentBrokeragePolicy implements BrokeragePolicy{

    private final List<BrokerageRule> rules;

    public RentBrokeragePolicy(){
        rules = Arrays.asList(
                new BrokerageRule(50_000_000L, 0.5, 200000L),
                new BrokerageRule(100_000_000L, 0.4, 300000L),
                new BrokerageRule(300_000_000L, 0.3),
                new BrokerageRule(600_000_000L, 0.4),
                new BrokerageRule(Long.MAX_VALUE, 0.8)
        );
    }

}
