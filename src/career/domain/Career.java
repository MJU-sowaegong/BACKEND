package career.domain;// career.domain.Career

import member.domain.Member;

public class Career {
    private final Long id;
    private final Member member;
    private Member professor;
    private final String content;

    private Career(Builder builder) {
        this.id = builder.id;
        this.member = builder.member;
        this.content = builder.content;
        this.professor =builder.professor;
    }

    public static class Builder {
        private Long id;
        private Member member;
        private String content;
        private Member professor;
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder member(Member member) {
            this.member = member;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder professor(Member professor) {
            this.professor = professor;
            return this;
        }

        public Career build() {
            return new Career(this);
        }
    }
    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }
    public Member getMember() {
        return member;
    }
    public Member getProfessor() { return professor;    }
    public String getContent() {
        return content;
    }
}
