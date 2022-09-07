package com.cleancode.houseutils.policy;
/**
 * @author ggmd
 * 임대차일때 중개수수료 계산해주는 클래스
 * **/
public class RentBrokeragePolicy implements BrokeragePolicy{
    public BrokerageRule createBrokerageRule(Long price){
        BrokerageRule rule;
        if(price < 50000000){
            rule = new BrokerageRule(0.5, 200000L);
        } else if (price < 100000000){
            rule = new BrokerageRule(0.4, 300000L);
        } else if (price < 300000000){
            rule = new BrokerageRule(0.3, null);
        } else if (price < 600000000){
            rule = new BrokerageRule(0.4, null);
        } else {
            rule = new BrokerageRule(0.8, null);
        }

        return rule;
    }
}
