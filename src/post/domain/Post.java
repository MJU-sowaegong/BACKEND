package post.domain;

import member.domain.Member;

public class Post {
    Long id;
    Member member;
    String title;
    String content;
    PostCategory category;

    public Post(long id, Member member, PostCategory postCategory, String title, String content) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.category = postCategory;
    }

    public PostCategory getCategory() {
        return category;
    }
    public void getInformation() {
        //구현해주세요
        System.out.println("정보 출력");
    }
}
