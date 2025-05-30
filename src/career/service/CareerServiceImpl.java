package career.service;

import career.domain.Career;
import career.repository.CareerRepository;

public class CareerServiceImpl implements CareerService {
    private final CareerRepository careerRepository;

    public CareerServiceImpl(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @Override
    public void applyCareerConsultation(Career career) {
        //구현해주세요
    }

    @Override
    public Career[] getAllCareers() {
        //구현해주세요
        return new Career[0];
    }
}
