package member.controller;

import member.domain.Member;
import member.domain.Role;
import member.service.MemberService;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void registerMember(Long id, String name, Role role) {
        Member member = Member.builder()
                .id(id)
                .name(name)
                .role(role)
                .build();

        memberService.save(member);
    }
    public Member getMemberById(Long id) {
        return memberService.findById(id);
    }
}
