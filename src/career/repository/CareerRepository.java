package career.repository;

import career.domain.Career;

import java.util.ArrayList;
import java.util.List;

public class CareerRepository {
    private final List<Career> careers = new ArrayList<>();

    public void save(Career career) {
        careers.add(career);
    }

    public List<Career> findAll() {
        return new ArrayList<>(careers);
    }
}
