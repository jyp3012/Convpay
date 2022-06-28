package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayCancelResult;

public class PayCancelReponse {
    PayCancelResult payCancelResult;
    Integer PayCancelAmount;

    public PayCancelReponse(PayCancelResult payCancelResult, Integer payCancelAmount) {
        this.payCancelResult = payCancelResult;
        PayCancelAmount = payCancelAmount;
    }

    public PayCancelResult getPayCancelResult() {
        return payCancelResult;
    }

    public void setPayCancelResult(PayCancelResult payCancelResult) {
        this.payCancelResult = payCancelResult;
    }

    public Integer getPayCancelAmount() {
        return PayCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        PayCancelAmount = payCancelAmount;
    }

    @Override
    public String toString() {
        return "PayCancelReponse{" +
                "payCancelResult=" + payCancelResult +
                ", PayCancelAmount=" + PayCancelAmount +
                '}';
    }
}
