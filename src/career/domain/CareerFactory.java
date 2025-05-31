package career.domain;

import member.domain.Member;

public class CareerFactory {
    public static Career createCareer(Member member, Member professor, String content) {
        return Career.builder()
                .member(member)
                .professor(professor)
                .content(content)
                .build();
    }
}
