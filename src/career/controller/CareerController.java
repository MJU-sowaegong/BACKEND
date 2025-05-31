package career.controller;

import career.domain.Career;
import career.service.CareerService;
import member.domain.Member;

import java.util.List;

public class CareerController {

    private final CareerService careerService;

    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    public void applyCareer(Long id, Member member, String content, Member professor) {
        careerService.applyCareerConsultation(id, member, content, professor);
    }

    public List<Career> getAllCareers() {
        return careerService.getAllCareers();
    }
}
