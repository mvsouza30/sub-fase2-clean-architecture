package sub.fase2.cleanarchitecture.carsales.application.contracts;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;

import java.util.List;

public class CarCollection {
    private final List<Car> cars;

    public CarCollection(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
