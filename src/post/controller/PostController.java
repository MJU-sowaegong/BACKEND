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
        postService.write(id, member, category, title, content);
    }

    public List<Post> getPosts(Long memberId, PostCategory category) {
        return postService.getPosts(memberId, category);
    }
}
