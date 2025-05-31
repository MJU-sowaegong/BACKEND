package career.service;// career.service.CareerServiceImpl
import career.domain.Career;
import career.domain.CareerFactory;
import career.repository.CareerRepository;
import member.domain.Member;
import member.domain.Role;

import java.util.List;

public class CareerServiceImpl implements CareerService {
    private final CareerRepository careerRepository;

    public CareerServiceImpl(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @Override
    public List<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    @Override
    public void applyCareerConsultation(Long id, Member member, String content, Member professor) {
        System.out.println("[진로 상담 신청] 요청 시작 - 신청자: " + member.getName() + ", 교수님: " + (professor != null ? professor.getName() : "null"));

        if (professor == null || professor.getRole() != Role.PROFESSOR) {
            System.out.println("[오류] 대상 교수님이 유효하지 않습니다.");
            return;
        }

        if (member.getRole() != Role.STUDENT) {
            System.out.println("[오류] 진로 상담 신청 권한이 없습니다. (권한: " + member.getRole() + ")");
            return;
        }

        System.out.println("정상 요청입니다.");

        Career career = CareerFactory.createCareer(member, professor, content);

        careerRepository.save(career);
        System.out.println("[성공] 진로 상담 신청이 완료되었습니다. 신청자: " + member.getName() + ", 교수님: " + professor.getName());

    }
}
