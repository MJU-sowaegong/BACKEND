import career.controller.CareerController;
import career.domain.Career;
import career.repository.CareerRepository;
import career.service.*;
import member.controller.MemberController;
import member.domain.Member;
import member.domain.Role;
import member.repository.MemberRepository;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import post.controller.PostController;
import post.domain.Post;
import post.domain.PostCategory;
import post.repository.PostRepository;
import post.service.PostService;
import post.service.PostServiceImpl;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        // 레포지토리 생성 (싱글톤일 경우 getInstance()로 수정 가능)
        MemberRepository memberRepo = MemberRepository.getInstance();
        PostRepository postRepo = PostRepository.getInstance();
        CareerRepository careerRepo = CareerRepository.getInstance();

        //전략 페턴 적용
        // 전략 리스트 생성
        List<CareerApplyStrategy> strategies = List.of(
                new SuccessApplyStrategy(careerRepo), //성공 했을 경우의 전략
                new FailApplyStrategy() //실패 했을 경우의 전략
        );
        // 전략 팩토리 생성
        CareerApplyStrategyFactory strategyFactory = new CareerApplyStrategyFactory(strategies);


        // 서비스 생성
        MemberService memberService = new MemberServiceImpl(memberRepo);
        PostService postService = new PostServiceImpl(postRepo, memberRepo);
        CareerService careerService = new CareerServiceImpl(careerRepo, strategyFactory);

        // 컨트롤러 생성
        MemberController memberController = new MemberController(memberService);
        PostController postController = new PostController(postService);
        CareerController careerController = new CareerController(careerService);

        // 테스트 데이터 생성
        createTestData(memberController, postController);

        // 회원 정보 가져오기
        Member member1 = memberRepo.findById(1L);
        Member member2 = memberRepo.findById(2L);
        Member member3 = memberRepo.findById(3L);
        Member member4 = memberRepo.findById(4L);
        Member member5 = memberRepo.findById(5L);
        Member member6 = memberRepo.findById(6L);


//   ----------------------------------------- Controller로 요청 받기 -----------------------------------------------
        // 기능 1. 게시글 조회 (멤버 1의 FREE 게시글)
        System.out.println("-------------------------기능 1. 카테고리별 게시글 조회------------------------------");
        System.out.println("[게시글 조회] 멤버 1 (오창민)의 QNA 게시글 조회");
        List<Post> postsQna = postController.getPosts(1L, PostCategory.QNA);
        System.out.println("[게시글 조회 결과] ");
        for (Post post : postsQna) {
            post.getInformation();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("[게시글 조회] 멤버 1 (오창민)의 FREE 게시글 조회");
        List<Post> postsfree = postController.getPosts(1L, PostCategory.FREE);
        System.out.println("[게시글 조회 결과] ");
        for (Post post : postsfree) {
            post.getInformation();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("[게시글 조회] 멤버 2 (고은)의 NOTICE 게시글 조회");
        List<Post> posts2 = postController.getPosts(2L, PostCategory.NOTICE);
        System.out.println("[게시글 조회 결과] ");
        for (Post post : posts2) {
            post.getInformation();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("[게시글 조회] 멤버 3 (윤서)의 FREE 게시글 조회");
        List<Post> posts3 = postController.getPosts(3L, PostCategory.FREE);
        System.out.println("[게시글 조회 결과] ");
        for (Post post : posts3) {
            post.getInformation();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("[게시글 조회] 멤버 3 (윤서)의 QNA 게시글 조회");
        List<Post> postList = postController.getPosts(3L, PostCategory.QNA);
        System.out.println("[게시글 조회 결과] ");
        for (Post post : postList) {
            post.getInformation();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("[게시글 조회] 멤버 4 (가희)의 FREE 게시글 조회");
        List<Post> posts4 = postController.getPosts(4L, PostCategory.FREE);
        System.out.println("[게시글 조회 결과] ");
        for (Post post : posts4) {
            post.getInformation();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("[게시글 조회] 멤버 5 (세민)의 QNA 게시글 조회");
        List<Post> posts5 = postController.getPosts(5L, PostCategory.QNA);
        System.out.println("[게시글 조회 결과] ");
        for (Post post : posts5) {
            post.getInformation();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("[게시글 조회] 멤버 5 (세민)의 NOTICE 게시글 조회 시도");
        List<Post> posts6 = postController.getPosts(5L, PostCategory.NOTICE);
        System.out.println("[게시글 조회 결과] ");
        for (Post post : posts6) {
            post.getInformation();
        }
        System.out.println("----------------------------------------------------------------");

        System.out.println();
        System.out.println("------------------------------------기능 2. 진로 상담 신청--------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("----------------------- 경력 상담 신청 테스트 케이스 시작 -------------------------");

        System.out.println("신청 시도: 오창민 (ADMIN) → 윤서 (PROFESSOR)");
        careerController.applyCareer(1L, member1, "백엔드 개발자가 되고 싶어요.", member3);
        System.out.println("----------------------------------------------------------------");

        System.out.println("신청 시도: 고은 (STUDENT) → 윤서 (PROFESSOR)");
        careerController.applyCareer(2L, member2, "프론트엔드 쪽으로 커리어 전환을 희망합니다.", member3);
        System.out.println("----------------------------------------------------------------");


        System.out.println("신청 시도: 오창민 (ADMIN) → 윤서 (PROFESSOR)");
        careerController.applyCareer(3L, member1, "데이터 사이언티스트가 되고 싶습니다.", member3);
        System.out.println("----------------------------------------------------------------");

        System.out.println("신청 시도: 가희 (GRADUATE) → 윤서 (PROFESSOR)");
        careerController.applyCareer(4L, member4, "졸업 후 커리어 상담을 원합니다.", member3);
        System.out.println("----------------------------------------------------------------");

        System.out.println("신청 시도: 고은 (STUDENT) → 고은 (STUDENT)");
        careerController.applyCareer(5L, member2, "커리어 상담 희망", member2);
        System.out.println("----------------------------------------------------------------");

        System.out.println("신청 시도: 세민 (GRADUATE) → null");
        careerController.applyCareer(6L, member5, "취업 준비 중입니다.", null);
        System.out.println("----------------------------------------------------------------");

        System.out.println("신청 시도: 세민 (STUDENT) → 이강선 (PROFESSOR)");
        careerController.applyCareer(7L, member5, "데이터 쪽으로 커리어 전환을 희망합니다.", member6);
        System.out.println("----------------------------------------------------------------");

        System.out.println("---- 경력 상담 신청 테스트 케이스 종료 ----");

        // 기능 2. 진로 상담 목록 출력
        System.out.println("\n[진로 상담 신청 목록]");
        List<Career> allCareers = careerController.getAllCareers();
        for (Career c : allCareers) {
            System.out.println("회원: " + c.getMember().getName() + ", 내용: " + c.getContent() + ", 교수님: " + c.getProfessor().getName() );
        }


    }

    private static void createTestData(MemberController memberController, PostController postController) {
        // 회원 여러명 등록
        System.out.println("---------------------------------------테스트 데이터 삽입--------------------------------");
        System.out.println("회원 등록: 창민 (ADMIN)");
        memberController.registerMember(1L, "오창민", Role.ADMIN);
        System.out.println("회원 등록: 고은 (STUDENT)");
        memberController.registerMember(2L, "고은", Role.STUDENT);
        System.out.println("회원 등록: 윤서 (PROFESSOR)");
        memberController.registerMember(3L, "윤서", Role.PROFESSOR);
        System.out.println("회원 등록: 가희 (GRADUATE)");
        memberController.registerMember(4L, "가희", Role.GRADUATE);
        System.out.println("회원 등록: 세민 (STUDENT)");
        memberController.registerMember(5L, "세민", Role.STUDENT);
        System.out.println("회원 등록: 이강선 (PROFESSOR)");
        memberController.registerMember(6L, "이강선", Role.PROFESSOR);

        // 회원 객체 미리 받아오기 (필요시)
        Member member1 = memberController.getMemberById(1L);
        Member member2 = memberController.getMemberById(2L);
        Member member3 = memberController.getMemberById(3L);
        Member member4 = memberController.getMemberById(4L);
        Member member5 = memberController.getMemberById(5L);
        System.out.println();
        // 게시글 여러 개 등록 (멤버1, 멤버2, 멤버3 각각 여러 글)
        System.out.println("게시글 등록: 오창민 - 첫 게시글 (FREE)");
        postController.writePost(1L, member1, PostCategory.FREE, "한 학기 동안", "수고 많으셨습니다.");
        System.out.println("게시글 등록: 오창민 - 두 번째 글 (FREE)");
        postController.writePost(2L, member1, PostCategory.FREE, "교수님", "사랑합니다.");
        System.out.println("게시글 등록: 오창민 - 질문 있습니다 (QNA)");
        postController.writePost(3L, member1, PostCategory.QNA, "질문 있습니다", "오창민의 질문 게시글");

        System.out.println("게시글 등록: 고은 - 게시글 (FREE)");
        postController.writePost(4L, member2, PostCategory.FREE, "고은의 게시글", "고은이 작성한 게시글입니다.");
        System.out.println("게시글 등록: 고은 - 공지사항 (NOTICE)");
        postController.writePost(5L, member2, PostCategory.NOTICE, "공지사항", "중요 공지사항입니다.");

        System.out.println("게시글 등록: 윤서 - 첫 글 (FREE)");
        postController.writePost(6L, member3, PostCategory.FREE, "윤서의 첫 글", "윤서가 쓴 글이에요.");

        System.out.println("게시글 등록: 가희 - 졸업 게시글 (FREE)");
        postController.writePost(7L, member4, PostCategory.FREE, "졸업 후기", "가희의 졸업 후기 썰 푼다.");

        System.out.println("게시글 등록: 세민 - 졸업 관련 질문 (QNA)");
        postController.writePost(8L, member5, PostCategory.QNA, "졸업 관련 질문", "세민의 졸업 관련 질문입니다.");


    }
}
