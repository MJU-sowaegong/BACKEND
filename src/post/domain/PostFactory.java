package post.domain;


import member.domain.Member;

public class PostFactory {
    public static Post createPost(Long id, Member member,PostCategory category , String title, String content) {
        return Post.builder()
                .id(id)
                .member(member)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }
}