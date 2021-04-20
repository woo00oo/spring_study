package com.example.springStudy.discount;

import com.example.springStudy.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
