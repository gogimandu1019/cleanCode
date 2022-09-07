package com.cleancode.houseutils.controller;

import com.cleancode.houseutils.constants.ActionType;
import com.cleancode.houseutils.policy.BrokeragePolicy;
import com.cleancode.houseutils.policy.BrokeragePolicyFactory;
import com.cleancode.houseutils.policy.PurchaseBrokeragePolicy;
import com.cleancode.houseutils.policy.RentBrokeragePolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author ggmd
 * */
@RestController
public class BrokerageQueryController {
    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType, @RequestParam Long price){
        //타입 - 매매 / 임대차
        //TODO : 중개수수료 계산로직

        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);

    }
}
