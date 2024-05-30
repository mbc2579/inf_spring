package hello.inf_spring.controller;

import hello.inf_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 별로 선호하지 않는 필드주입 방식
    // @Autowired private MemberService memberService;

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
