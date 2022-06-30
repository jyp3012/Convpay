package com.zerobase.convpay.service;

import com.zerobase.convpay.type.*;

public class MoneyAdapter implements PaymentInterface {
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

    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.MONEY;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        MoneyUseResult moneyUseResult = use(payAmount);

        if(moneyUseResult == MoneyUseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }

        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult CancelPayment(Integer cancelAmount) {
        MoneyuseCancelResult moneyuseCancelResult = useCancel(cancelAmount);

        if (moneyuseCancelResult == MoneyuseCancelResult.MONEYUSE_CANCEL_FAIL) {
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }

        return  CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
