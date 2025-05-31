package career.service;
import career.domain.Career;
import career.repository.CareerRepository;
import member.domain.Member;

import java.util.List;

public class CareerServiceImpl implements CareerService {
    private final CareerRepository careerRepository;
    private final CareerApplyStrategyFactory strategyFactory;
    public CareerServiceImpl(CareerRepository careerRepository, CareerApplyStrategyFactory strategyFactory) {
        this.careerRepository = careerRepository;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public List<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    @Override
    public void applyCareerConsultation(Long id, Member member, String content, Member professor) {
        System.out.println("[진로 상담 신청] 요청 시작 - 신청자: " + member.getName() + ", 교수님: " + (professor != null ? professor.getName() : "null"));


        CareerApplyStrategy strategy = strategyFactory.getStrategy(member.getRole(), professor != null ? professor.getRole() : null);

        strategy.apply(member,professor,content);

    }
}
