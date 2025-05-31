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
            if (strategy instanceof SuccessApplyStrategy) { // 성공의
                strategyMap.put(new RolePair(Role.STUDENT, Role.PROFESSOR), strategy);
            }
        }
    }

    public CareerApplyStrategy getStrategy(Role memberRole, Role professorRole) {
        return strategyMap.getOrDefault(new RolePair(memberRole, professorRole), new FailApplyStrategy());
    }
}
