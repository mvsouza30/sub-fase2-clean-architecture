package sub.fase2.cleanarchitecture.carsales.application.usecases;

import sub.fase2.cleanarchitecture.carsales.application.gateways.CarGateway;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;

public class CreateCarUseCase {
    private CarGateway carGateway;

    public CreateCarUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }

    public Car createCar(Car car){
        return carGateway.createCar(car);
    }
}
