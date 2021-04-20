package com.example.springStudy.Order;

import com.example.springStudy.discount.DiscountPolicy;
import com.example.springStudy.discount.FixDiscountPolicy;
import com.example.springStudy.member.Member;
import com.example.springStudy.member.MemberRepository;
import com.example.springStudy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인 정책에게 회원정보 던져줌(메시지 전달) 객체간의 협력관계 형성
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
