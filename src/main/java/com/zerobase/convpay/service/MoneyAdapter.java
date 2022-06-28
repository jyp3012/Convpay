package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.MoneyuseCancelResult;

public class MoneyAdapter {
    public MoneyUseResult use(Integer payAmount) {

        System.out.println("MoneyAdapter.use : " + payAmount);

        if (payAmount > 1000_000) {
            return MoneyUseResult.USE_FAIL;
        }
        return MoneyUseResult.USE_SUCCESS;
    }

    public MoneyuseCancelResult useCancel(Integer payCancelAmount) {

        System.out.println("MoneyAdapter.useCancel : " + payCancelAmount);

        if (payCancelAmount < 100) {
            return MoneyuseCancelResult.MONEYUSE_CANCEL_FAIL;
        }
        return MoneyuseCancelResult.MONEYUSE_CANCEL_SUCCESS;
    }
}
