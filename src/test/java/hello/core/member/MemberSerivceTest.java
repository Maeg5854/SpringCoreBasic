package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberSerivceTest {
    MemberSerivce memberSerivce = new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberSerivce.join(member);
        Member member1 = memberSerivce.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(member1);
    }
}
