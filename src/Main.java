import career.domain.Career;
import career.repository.CareerRepository;
import member.domain.Member;
import member.repository.MemberRepository;
import post.domain.Post;
import career.service.CareerService;
import career.service.CareerServiceImpl;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import post.domain.PostCategory;
import post.repository.PostRepository;
import post.service.PostService;
import post.service.PostServiceImpl;



public class Main {
    public static void main(String[] args) {
        // Repository 객체 생성
        MemberRepository memberRepo = new MemberRepository();
        PostRepository postRepo = new PostRepository();
        CareerRepository careerRepo = new CareerRepository();

        // 서비스 객체 초기화 (인터페이스로 선언)
        MemberService memberService = new MemberServiceImpl(memberRepo);
        PostService postService = new PostServiceImpl(postRepo);
        CareerService careerService = new CareerServiceImpl(careerRepo);

        // 테스트 데이터 삽입
        System.out.println("테스트 데이터 삽입");

        Member member = new Member(1L, "오창민");
        memberService.save(member);

        Post post1 = new Post(1L, member, PostCategory.FREE, "첫 게시글", "내용입니다");
        Post post2 = new Post(2L, member, PostCategory.FREE, "두 번째 글", "또 다른 내용");

        postService.write(post1);
        postService.write(post2);

        // 기능 1 : 게시글 목록 조회
        System.out.println("\n기능 1 : 게시글 목록 조회 (FREE)");
        for (Post post : postService.getPosts(1L, PostCategory.FREE)) {
            post.getInformation(); // 정보 출력 메서드 가정
        }

        // 기능 2 : 진로 상담 신청
        System.out.println("\n기능 2 : 진로 상담 신청");
        Career career = new Career(1L, member, "백엔드 개발자가 되고 싶어요.");
        careerService.applyCareerConsultation(career);

        System.out.println("신청된 진로 상담 목록:");
        for (Career c : careerService.getAllCareers()) {
            System.out.println("회원: " + c.getMember().getName() + ", 내용: " + c.getContent());
        }
    }
}