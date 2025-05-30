package career.service;

import career.domain.Career;

public interface CareerService {

    void applyCareerConsultation(Career career);

    Career[] getAllCareers();
}
