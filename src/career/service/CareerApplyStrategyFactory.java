package career.service;

import member.domain.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CareerApplyStrategyFactory {
    private final Map<RolePair, CareerApplyStrategy> strategyMap = new HashMap<>();

    public CareerApplyStrategyFactory(List<CareerApplyStrategy> strategies) {
        // 생성자 주입
        for (CareerApplyStrategy strategy : strategies) {
            if (strategy instanceof SuccessApplyStrategy) { // 학생이, 교수님께 신청했을 때 성공
                strategyMap.put(new RolePair(Role.STUDENT, Role.PROFESSOR), strategy);
            }
        }
    }

    public CareerApplyStrategy getStrategy(Role memberRole, Role professorRole) {
        return strategyMap.getOrDefault(new RolePair(memberRole, professorRole), new FailApplyStrategy()); //복합키 [학생 역할, 교수 역할]로 map에서 전략 꺼내기
    }
}
