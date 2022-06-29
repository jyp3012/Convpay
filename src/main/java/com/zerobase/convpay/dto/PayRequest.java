package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMathodType;

public class PayRequest {
    //결제 수단
    PayMathodType payMathodType;
    //편의점 종류
    ConvenienceType convenienceType;

    //결제 금액
    Integer payAmount;

    public PayMathodType getPayMathodType() {
        return payMathodType;
    }

    public void setPayMathodType(PayMathodType payMathodType) {
        this.payMathodType = payMathodType;
    }

    public PayRequest(PayMathodType payMathodType, ConvenienceType convenienceType, Integer payAmount) {
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
        this.payMathodType = payMathodType;
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
