package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayResult;

public class ConveniencePayService { // 편걸이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();

    public PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());

        // 실패와 성공 케이스를 if else 문으로 처리 하는 것은 삼가하고
        // fail fast

        // Method()

        // Exception case4
        // Exception case5
        // Exception case1
        // Exception case2
        // Exception case3

        // Success Case(Only one)

        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case
        return new PayResponse(PayResult.SUCCESS, 100);

    }

    public PayCancelReponse payCancel(PayCancelRequest payCancelRequest) {
        moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

        return new PayCancelReponse(PayCancelResult.PAY_CANCEL_SUCCESS, 100);
    }
}
