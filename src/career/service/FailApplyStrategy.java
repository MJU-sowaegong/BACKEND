package career.service;

import member.domain.Member;
import member.domain.Role;

public class FailApplyStrategy implements CareerApplyStrategy {
    @Override
    public void apply(Member member, Member professor, String content) {

        if (professor == null || professor.getRole() != Role.PROFESSOR) {
            System.out.println("[오류] 대상 교수님이 유효하지 않습니다.");
        }

        if (member.getRole() != Role.STUDENT) {
            System.out.println("[오류] 진로 상담 신청 권한이 없습니다. (권한: " + member.getRole() + ")");
        }
    }
}
