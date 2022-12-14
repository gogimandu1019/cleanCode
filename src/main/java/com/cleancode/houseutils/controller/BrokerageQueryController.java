package com.cleancode.houseutils.controller;

import com.cleancode.houseutils.constants.ActionType;
import com.cleancode.houseutils.policy.BrokeragePolicy;
import com.cleancode.houseutils.policy.BrokeragePolicyFactory;
import com.cleancode.houseutils.policy.BrokerageRule;
import com.cleancode.houseutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.http11.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author ggmd
 * 
 * 중개수수료가 얼마인지 조회하는 컨트롤러
 * */
@RestController
@AllArgsConstructor
public class BrokerageQueryController {
    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType, @RequestParam Long price){
        //TODO : 중개수수료 계산로직
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);

    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(
            @PathVariable Long apartmentId,
            @RequestParam ActionType actionType
    ) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        Long price = apartmentService.getPriceOrThrow(apartmentId);
        return policy.calculate(price);
    }
}
