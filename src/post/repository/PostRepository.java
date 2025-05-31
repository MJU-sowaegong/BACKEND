package post.repository;// post.repository.PostRepository
import post.domain.Post;
import post.domain.PostCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepository {
    private static final PostRepository INSTANCE = new PostRepository();

    private final List<Post> posts = new ArrayList<>();

    private PostRepository() {}

    public static PostRepository getInstance() {
        return INSTANCE;
    }

    public void save(Post post) {
        posts.add(post);
    }

    public List<Post> findAllByCategory(PostCategory category) {
        return posts.stream()
                .filter(post -> post.getCategory() == category)
                .collect(Collectors.toList());
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }
}
