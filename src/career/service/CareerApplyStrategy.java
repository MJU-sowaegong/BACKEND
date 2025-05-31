package career.service;

import member.domain.Member;

public interface CareerApplyStrategy {
    void apply(Member member, Member professor, String content);
}
