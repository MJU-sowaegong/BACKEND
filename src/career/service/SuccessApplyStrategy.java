package career.service;

import career.domain.Career;
import career.domain.CareerFactory;
import career.repository.CareerRepository;
import member.domain.Member;

public class SuccessApplyStrategy implements CareerApplyStrategy{
    private final CareerRepository careerRepository;

    public SuccessApplyStrategy(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @Override
    public void apply(Member member, Member professor, String content) {
        Career career = CareerFactory.createCareer(member, professor, content);
        careerRepository.save(career);
        System.out.println("[성공] 진로 상담 신청이 완료되었습니다. 신청자: " + member.getName() + ", 교수님: " + professor.getName());
    }
}
