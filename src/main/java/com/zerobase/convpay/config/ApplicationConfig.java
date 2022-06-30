package com.zerobase.convpay.config;

import com.zerobase.convpay.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {
    @Bean
    public ConveniencePayService conveniencePayServiceDiscountConvenience() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(MoneyAdapter(), CardAdapter())
                ),
                DiscountByConvenience()
        );
    }

    private CardAdapter CardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public MoneyAdapter MoneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    public DiscountByConvenience DiscountByConvenience() {
        return new DiscountByConvenience();
    }

    @Bean
    public ConveniencePayService conveniencePayServiceDiscountPayMethod() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(MoneyAdapter(), CardAdapter())
                ),
                discountByPayMethod()
        );
    }

    private DicountByPayMethod discountByPayMethod() {
        return new DicountByPayMethod();
    }
}
