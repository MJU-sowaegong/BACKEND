package post.service;

import member.domain.Member;
import post.domain.Post;
import post.domain.PostCategory;

import java.util.List;

public interface PostService {
    List<Post> getPosts(Long memberId, PostCategory category);

    void write(Long id, Member member, PostCategory category, String title, String content);
}