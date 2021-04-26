package com.example.springStudy.order;

import com.example.springStudy.discount.DiscountPolicy;
import com.example.springStudy.member.Member;
import com.example.springStudy.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
/*
    클라이언트인 'OrderServiceImpl'이 'DiscountPolicy' 인터페이스 뿐만 아니라, 'FixDiscountPolicy'인 구현체 클래스도 함께 의존 하고 있다. => DIP 위반
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    'FixDiscountPolicy를 'RateDiscountPolicy'로 변경하는 순간 'OrderServiceImpl'의 소스코드도 함께 변경 해야 한다. => OCP 위반
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
 */
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인 정책에게 회원정보 던져줌(메시지 전달) 객체간의 협력관계 형성
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
