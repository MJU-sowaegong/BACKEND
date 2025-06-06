package member.repository;

import member.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static final MemberRepository instance = new MemberRepository();
    private final List<Member> members = new ArrayList<>();

    private MemberRepository() {}

    public static MemberRepository getInstance() {
        return instance;
    }

    public void save(Member member) {
        members.add(member);
    }

    public List<Member> findAll() {
        return new ArrayList<>(members);
    }

    public Member findById(Long id) {
        return members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
