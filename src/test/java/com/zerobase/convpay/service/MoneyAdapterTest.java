package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.MoneyuseCancelResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyAdapterTest {
    MoneyAdapter moneyAdapter = new MoneyAdapter();


    @Test
    void money_use_fail() {
        //given
        Integer payAmount = 1000_001;

        //when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        //then
        assertEquals(moneyUseResult.USE_FAIL, moneyUseResult);
      }

    @Test
    void money_use_success() {
        //given
        Integer payAmount = 1000_000;

        //when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        //then
        assertEquals(moneyUseResult.USE_SUCCESS, moneyUseResult);
    }

    @Test
    void money_use_cancel_success() {
        //given
        Integer payCancelAmount = 100;

        //when
        MoneyuseCancelResult moneyuseCancelResult = moneyAdapter.useCancel(payCancelAmount);

        //then
        assertEquals(MoneyuseCancelResult.MONEYUSE_CANCEL_SUCCESS, moneyuseCancelResult);
      }

    @Test
    void money_use_cancel_fail() {
        //given
        Integer payCancelAmount = 99;

        //when
        MoneyuseCancelResult moneyuseCancelResult = moneyAdapter.useCancel(payCancelAmount);

        //then
        assertEquals(MoneyuseCancelResult.MONEYUSE_CANCEL_FAIL, moneyuseCancelResult);
    }

}