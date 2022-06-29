package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.CarduseCancelResult;
import com.zerobase.convpay.type.CarduseResult;
import com.zerobase.convpay.type.PaymentResult;

public class CardAdapter implements PaymentInterface{
    // 1. 인증
    public void authorization(){
        System.out.println(" authorization success. ");
    }

    // 2. 승인
    public void approval(){
        System.out.println("approval success. ");
    }

    // 3. 매입
    public CarduseResult capture(Integer payAmount) {
        if (payAmount > 100) {
            // 길패

            return CarduseResult.USE_FAIL;
        }

        return CarduseResult.USE_SUCCUSS;
    }
    // 4. 매입취소
    public CarduseCancelResult captureCancel(Integer payAmount) {
        if (payAmount < 1000) {
            // 1. 실패
            return CarduseCancelResult.USE_CANCEL_FAIL;
        }

        return CarduseCancelResult.USE_CANCEL_SUCCUSS;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        CarduseResult carduseResult = capture(payAmount);

        if(carduseResult == CarduseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }

        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult CancelPayment(Integer cancelAmount) {
        CarduseCancelResult carduseCancelResult = captureCancel(cancelAmount);

        if (carduseCancelResult == CarduseCancelResult.USE_CANCEL_FAIL) {
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }

        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
