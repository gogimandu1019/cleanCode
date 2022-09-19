package com.cleancode.houseutils.policy;

import com.cleancode.houseutils.constants.ActionType;
import com.cleancode.houseutils.exception.ErrorCode;
import com.cleancode.houseutils.exception.HouseUtilsException;

/**
 * @author ggmd
 * */
public class BrokeragePolicyFactory {
    private static final RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy();
    private static final PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();

    public static BrokeragePolicy of(ActionType actionType){
        switch(actionType){
            case RENT:
                return rentBrokeragePolicy;
            case PURCHASE:
                return purchaseBrokeragePolicy;
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 actionType에 대한 정책이 존재하지 않습니다.");
        }
    }
}
