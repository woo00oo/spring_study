package com.example.springStudy;

import com.example.springStudy.Order.Order;
import com.example.springStudy.Order.OrderService;
import com.example.springStudy.Order.OrderServiceImpl;
import com.example.springStudy.member.Grade;
import com.example.springStudy.member.Member;
import com.example.springStudy.member.MemberService;
import com.example.springStudy.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
