package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository_practice {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member_practice member) {
        em.persist(member);
        return member.getId();
    }

    public Member_practice find(Long id) {
        return em.find(Member_practice.class, id);
    }

}
