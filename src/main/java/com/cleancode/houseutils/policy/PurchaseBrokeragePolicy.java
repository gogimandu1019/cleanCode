package com.cleancode.houseutils.policy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ggmd
 * 매매일때 중개수수료 계산해주는 클래스
 * **/
@Getter
public class PurchaseBrokeragePolicy implements BrokeragePolicy{

    private final List<BrokerageRule> rules;

    public PurchaseBrokeragePolicy(){
        rules = Arrays.asList(
                new BrokerageRule(50_000_000L, 0.6, 250000L),
                new BrokerageRule(200_000_000L,0.5, 800000L),
                new BrokerageRule(600_000_000L,0.4),
                new BrokerageRule(900_000_000L,0.5),
                new BrokerageRule(Long.MAX_VALUE,0.9)
        );
    }


}
