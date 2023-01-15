package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberSerivce;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 실제 동작에 필요한 구현 객체를 생성하는 클래스
// 구현체간의 구성을 짜는 클래스
@Configuration
public class AppConfig {
    // 구성 정보가 잘 드러나도록, 각 구현체에 대한 getter를 설정
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberSerivce memberService() {
        // 생성자를 통해서 구현체를 주입시킨다.
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        /*return new FixDiscountPolicy();*/
        return new RateDiscountPolicy();
    }
}
