package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

// JPA를 사용하면 SQL 쿼리도 자동으로 처리해주므로 개발 생산성을 크게 높일 수 있다.
// 또한, SQL과 데이터 중심 설계에서 객체 중심의 설계로 패러다임을 전환할 수 있다.
// JPA는 인터페이스이다. 그 구현체 중 hibernate을 사용한다.
// JPA는 객체와 ORM(Object Relational Mapping) 기술을 이용한다.
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // JPQL이라는 객체지향 쿼리를 사용
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
