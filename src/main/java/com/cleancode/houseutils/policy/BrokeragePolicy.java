package com.cleancode.houseutils.policy;

import com.cleancode.houseutils.exception.ErrorCode;
import com.cleancode.houseutils.exception.HouseUtilsException;

import java.util.List;

/**
 * @author ggmd
 *
 * */
public interface BrokeragePolicy {
    List<BrokerageRule> getRules();

    default Long calculate(Long price){
        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessThen())
                .findFirst().orElseThrow(()-> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));

        return brokerageRule.calcMaxBrokerage(price);
    }
}
