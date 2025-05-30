package post.service;

import post.domain.Post;
import post.domain.PostCategory;
import post.repository.PostRepository;

import java.util.List;

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;

    }
    @Override
    public List<Post> getPosts(Long memberId, PostCategory category) {
        return List.of();
    }

    @Override
    public void write(Post post1) {

    }
}
