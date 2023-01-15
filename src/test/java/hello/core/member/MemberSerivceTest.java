package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberSerivceTest {
//    MemberSerivce memberSerivce = new MemberServiceImpl();
    MemberSerivce memberSerivce;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberSerivce = appConfig.memberService();
    }
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
