package com.example.shop.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 개별 회원 정보 조회
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 회원 목록 조회
    //em.find는 하나밖에 조회 못함 -> JPQL 사용
    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    // 중복된 로그인 아이디가 있는지 확인
    // 예시) findByLoginId("abc123")
    //      SELECT * FROM member WHERE login_id = 'abc123';
    public Member findByLoginId(string loginId) {
        List<Member> result = em.createQuery(
                "SELECT m FROM Member m WHERE m.loginID = :loginId", Member.class
        ).setParameter("loginId",loginId).getResultList();  // 파라미터 바인딩

        return result.isEmpty() ? null : result.get(0);
        //리스트가 비어있으면 null 반환,
        // 결과가 있을 때는 아이디가 겹치는 회원은 없으므로 리스트의 첫번째 회원(인덱스 0) 반환
    }

    // 회원 정보 저장
    public void save(Member member) {
        em.persist(member);
    }

    // 회원 정보 삭제
    public void deleteById(Long id) {
        Member member = em.find(Member.class, id);
        em.remove((member));
    }


}
