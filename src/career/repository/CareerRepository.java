package career.repository;// career.repository.CareerRepository
import career.domain.Career;

import java.util.ArrayList;
import java.util.List;

public class CareerRepository {
    private static final CareerRepository INSTANCE = new CareerRepository();
    private final List<Career> careers = new ArrayList<>();

    private CareerRepository() {}

    public static CareerRepository getInstance() {
        return INSTANCE;
    }

    public void save(Career career) {
        careers.add(career);
    }

    public List<Career> findAll() {
        return new ArrayList<>(careers);
    }
}
