package career.domain;

import member.domain.Member;

public class Career {
    Long id;
    Member member;
    String content;

    public Career(long id, Member member, String content) {
        this.id = id;
        this.member = member;
        this.content = content;
    }
    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }
    public String getContent() {
        return content;
    }
}
