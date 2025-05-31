package post.domain;// post.domain.Post

import member.domain.Member;

public class Post {
    private final Long id;
    private final Member member;
    private final PostCategory category;
    private final String title;
    private final String content;

    private Post(Builder builder) {
        this.id = builder.id;
        this.member = builder.member;
        this.category = builder.category;
        this.title = builder.title;
        this.content = builder.content;
    }

    public static class Builder {
        private Long id;
        private Member member;
        private PostCategory category;
        private String title;
        private String content;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder member(Member member) {
            this.member = member;
            return this;
        }

        public Builder category(PostCategory category) {
            this.category = category;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }


    public void getInformation() {
        System.out.println("작성자: " + member.getName() + ", 제목: " + title + ", 내용: " + content + ", 카테고리: " + category.name());
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public PostCategory getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
