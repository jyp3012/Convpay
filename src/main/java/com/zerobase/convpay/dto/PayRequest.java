package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class PayRequest {
    //결제 수단
    PayMethodType payMethodType;
    //편의점 종류
    ConvenienceType convenienceType;

    //결제 금액
    Integer payAmount;

    public PayMethodType getPayMathodType() {
        return payMethodType;
    }

    public void setPayMathodType(PayMethodType payMathodType) {
        this.payMethodType = payMethodType;
    }

    public PayRequest(PayMethodType payMathodType, ConvenienceType convenienceType, Integer payAmount) {
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
        this.payMethodType = payMathodType;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }
}
