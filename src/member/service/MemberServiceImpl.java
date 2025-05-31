package member.service;

import member.domain.Member;
import member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }
}
