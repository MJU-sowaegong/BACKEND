package post.controller;

import member.domain.Member;
import post.domain.Post;
import post.domain.PostCategory;
import post.service.PostService;

import java.util.List;

public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public void writePost(Long id, Member member, PostCategory category, String title, String content) {
        Post post = Post.builder()
                .id(id)
                .member(member)
                .category(category)
                .title(title)
                .content(content)
                .build();

        postService.write(post);
    }

    public List<Post> getPosts(Long memberId, PostCategory category) {
        return postService.getPosts(memberId, category);
    }
}
