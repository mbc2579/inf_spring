package hello.inf_spring;

import hello.inf_spring.repository.MemberRepository;
import hello.inf_spring.repository.MemoryMemberRepository;
import hello.inf_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
