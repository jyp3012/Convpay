package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

public class ConveniencePayService { // 편걸이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    // 만약 아래 코드로 의존성을 주입 해준다면 밑에 있는 코드 전체를 고쳐야 한다.
     private final CardAdapter cardAdapter = new CardAdapter();

    public PayResponse pay(PayRequest payRequest) {
        CarduseResult carduseResult;
        MoneyUseResult moneyUseResult;

        if(payRequest.getPayMathodType() == PayMathodType.CARD) {
            cardAdapter.authorization();
            cardAdapter.approval();
            carduseResult = cardAdapter.capture(payRequest.getPayAmount());
        }else {
            moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());
        }



        // 실패와 성공 케이스를 if else 문으로 처리 하는 것은 삼가하고
        // fail fast

        // Method()

        // Exception case4
        // Exception case5
        // Exception case1
        // Exception case2
        // Exception case3

        // Success Case(Only one)

        if (moneyUseResult == MoneyUseResult.USE_FAIL || carduseResult == CarduseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case
        return new PayResponse(PayResult.SUCCESS, 100);

    }

    public PayCancelReponse payCancel(PayCancelRequest payCancelRequest) {
        MoneyuseCancelResult moneyuseCancelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

        if(moneyuseCancelResult == MoneyuseCancelResult.MONEYUSE_CANCEL_FAIL) {
            return new PayCancelReponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelReponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
