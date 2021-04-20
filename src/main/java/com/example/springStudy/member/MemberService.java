package com.example.springStudy.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
