package post.service;

import post.domain.Post;
import post.domain.PostCategory;

import java.util.List;

public interface PostService {
    void write(Post post);
    List<Post> getPosts(Long memberId, PostCategory category);
}