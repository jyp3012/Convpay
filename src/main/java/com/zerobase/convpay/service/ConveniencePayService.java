package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

public class ConveniencePayService { // 편걸이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    // 만약 아래 코드처럼 각각 의존성을 주입 해준다면 밑에 있는 코드 전체를 고쳐야 한다.
     private final CardAdapter cardAdapter = new CardAdapter();
     private final DiscountInterface dicountInterface = new DicountByPayMethod();
    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if(payRequest.getPayMathodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        Integer discountAmount = dicountInterface.getDiscountedAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountAmount);


        // 실패와 성공 케이스를 if else 문으로 처리 하는 것은 삼가하고
        // fail fast

        // Method()

        // Exception case4
        // Exception case5
        // Exception case1
        // Exception case2
        // Exception case3

        // Success Case(Only one)

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case
        return new PayResponse(PayResult.SUCCESS, discountAmount);

    }

    public PayCancelReponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if(payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }
        CancelPaymentResult cancelPaymentResult = paymentInterface.CancelPayment(payCancelRequest.getPayCancelAmount());

        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelReponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelReponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
