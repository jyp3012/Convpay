package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConveniencePayService { // 편걸이
    private  final Map<PayMethodType, PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
     private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethodType(),
                        paymentInterface
                )
        );

        this.discountInterface = discountInterface;

    }

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface =
                paymentInterfaceMap.get(payRequest.getPayMethodType());

        Integer discountAmount = discountInterface.getDiscountedAmount(payRequest);
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
        PaymentInterface paymentInterface =
                paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

        CancelPaymentResult cancelPaymentResult =
                paymentInterface.CancelPayment(payCancelRequest.getPayCancelAmount());

        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelReponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelReponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
