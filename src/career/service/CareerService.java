package career.service;// career.service.CareerService
import career.domain.Career;
import member.domain.Member;

import java.util.List;

public interface CareerService {
    List<Career> getAllCareers();

    void applyCareerConsultation(Long id, Member member, String content, Member professor);
}
