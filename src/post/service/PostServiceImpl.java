package post.service;// post.service.PostServiceImpl
import member.domain.Member;
import member.domain.Role;
import member.repository.MemberRepository;
import post.domain.Post;
import post.domain.PostCategory;
import post.repository.PostRepository;

import java.util.Collections;
import java.util.List;

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostServiceImpl(PostRepository postRepository, MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }


    @Override
    public void write(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getPosts(Long memberId, PostCategory category) {
        // 멤버 가져오기
        Member member = memberRepository.findById(memberId);
        System.out.println("현재 사용자: " + member.getName() + ", 권한: " + member.getRole());

        // 멤버 확인
        if (member == null) {
            System.out.println("[오류] 해당 멤버가 존재하지 않습니다. (ID: " + memberId + ")");
            return Collections.emptyList();
        }


        // 권한 확인
        if (!member.getRole().equals(Role.STUDENT) && !member.getRole().equals(Role.ADMIN) && !member.getRole().equals(Role.GRADUATE)) {

            System.out.println("[오류] 게시글 조회 권한이 없습니다. (현재 권한: " + member.getRole() + ")");
            return Collections.emptyList();
        }

        return postRepository.findAllByCategory(category);
    }
}
