package member.service;

import member.domain.Member;

public interface MemberService {
    public void save(Member member);
    public Member findById(Long id);
}
