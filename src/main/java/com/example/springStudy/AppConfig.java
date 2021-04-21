package com.example.springStudy;

import com.example.springStudy.Order.OrderService;
import com.example.springStudy.Order.OrderServiceImpl;
import com.example.springStudy.discount.DiscountPolicy;
import com.example.springStudy.discount.FixDiscountPolicy;
import com.example.springStudy.discount.RateDiscountPolicy;
import com.example.springStudy.member.MemberRepository;
import com.example.springStudy.member.MemberService;
import com.example.springStudy.member.MemberServiceImpl;
import com.example.springStudy.member.MemoryMemberRepository;

public class AppConfig {

    //역할에 따른 구현이 보이도록 리팩터링

    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
    }

    private MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
