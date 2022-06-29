package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CarduseCancelResult;
import com.zerobase.convpay.type.CarduseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdapterTest {

    private CardAdapter cardAdapter = new CardAdapter();

    @Test
    void capture_succuss() {

        //given

        Integer payAmount = 99;

        //when
        CarduseResult carduseResult = cardAdapter.capture(payAmount);
        //then

        assertEquals(CarduseResult.USE_SUCCUSS, carduseResult);
      }

    @Test
    void capture_fail() {

        //given

        Integer payAmount = 101;

        //when
        CarduseResult carduseResult = cardAdapter.capture(payAmount);
        //then

        assertEquals(CarduseResult.USE_FAIL, carduseResult);
    }

    @Test
    void cancelCapture_success() {
        //given
        Integer cancelAmount = 1001;

        //when

        CarduseCancelResult carduseCancelResult = cardAdapter.captureCancel(cancelAmount);

        //then
        assertEquals(CarduseCancelResult.USE_CANCEL_SUCCUSS, carduseCancelResult);
      }


    @Test
    void cancelCapture_fail() {
        //given
        Integer cancelAmount = 999;

        //when

        CarduseCancelResult carduseCancelResult = cardAdapter.captureCancel(cancelAmount);

        //then
        assertEquals(CarduseCancelResult.USE_CANCEL_FAIL, carduseCancelResult);
    }

}