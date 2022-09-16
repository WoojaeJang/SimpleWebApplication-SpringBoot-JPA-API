package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest_practice {

    @Autowired
    MemberRepository_practice memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember_practice() throws Exception {
        //given
        Member_practice member = new Member_practice();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member_practice findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member:" + (findMember == member));

    }

}