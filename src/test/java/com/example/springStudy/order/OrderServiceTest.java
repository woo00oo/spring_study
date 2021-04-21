package com.example.springStudy.order;

import com.example.springStudy.AppConfig;
import com.example.springStudy.Order.Order;
import com.example.springStudy.Order.OrderService;
import com.example.springStudy.Order.OrderServiceImpl;
import com.example.springStudy.member.Grade;
import com.example.springStudy.member.Member;
import com.example.springStudy.member.MemberService;
import com.example.springStudy.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
