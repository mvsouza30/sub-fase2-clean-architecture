package sub.fase2.cleanarchitecture.carsales.application.gateways;

import sub.fase2.cleanarchitecture.carsales.application.contracts.CarCollection;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;

public interface CarGateway {
    Car createCar(Car car);
    Car editCar(Long carId, Car updatedCar);
    Car getCarById(Long carId);
    CarCollection getAllCarsOrderedByPrice();
}
