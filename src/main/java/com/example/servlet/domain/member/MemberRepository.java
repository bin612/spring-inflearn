package com.example.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 커멘드 + 쉬프트 + t
public class MemberRepository  {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // static 사용, id 자동 증가

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // store에 모든 값들을 꺼내서 ArrayList에 새로 담아서 넘겨준다.
        // 이렇게 하는 이유는 store에 있는 값들을 건들고 싶지 않아서 새로 담아서 사용
        return new ArrayList<>(store.values());
    }

    //store를 다 날려 버리는 것
    public void clearStore() {
        store.clear();
    }
}
