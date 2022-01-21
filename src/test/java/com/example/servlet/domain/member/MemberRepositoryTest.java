package com.example.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// Junit 5 부터는 public 필요가 없음
class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    // 테스트가 끝나면 초기화를 해주기 위해 사용
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void save() {
        //given : 이런게 주어 졌을 떄
        Member member = new Member("hello", 29);

        //when : 이걸 실행 했을 때
        Member savedMember = memberRepository.save(member);

        //then : 결과가 이거여야해
        Member findMember = memberRepository.findById(savedMember.getId());
        //찾아온 멤버는 저장된 멤버랑 같아야 한다.
        assertThat(findMember).isEqualTo(savedMember);
    }

    // 모두 테스트
    @Test
    void findAll() {

        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 29);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);

    }
}
