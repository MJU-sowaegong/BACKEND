package post.repository;

import post.domain.Post;
import post.domain.PostCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepository {
    private final List<Post> posts = new ArrayList<>();

    public void save(Post post) {
        posts.add(post);
    }

    public List<Post> findByCategory(PostCategory category) {
        return posts.stream()
                .filter(post -> post.getCategory() == category)
                .collect(Collectors.toList());
    }
}
