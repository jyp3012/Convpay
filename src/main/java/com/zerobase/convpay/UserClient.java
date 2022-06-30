package com.zerobase.convpay;

import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.dto.PayCancelReponse;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // '사용자' -> 편결이 -> 머니
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService = applicationContext.getBean("conveniencePayService",
                ConveniencePayService.class);
        // 결제 1000원

        PayRequest payRequest = new PayRequest(PayMethodType.CARD,
                ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);


        System.out.println(payResponse);

        // 취소를 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.CARD,
                ConvenienceType.G25, 1100);
        PayCancelReponse payCancelReponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelReponse);

    }
}
