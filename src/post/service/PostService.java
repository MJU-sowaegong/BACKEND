package post.service;

import post.domain.Post;
import post.domain.PostCategory;

import java.util.List;

public interface PostService {
    List<Post> getPosts(Long memberId, PostCategory category);

    void write(Post post1);
}
