package sub.fase2.cleanarchitecture.carsales.application.gateways;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;

public interface CarGateway {
    Car createCar(Car car);
}
