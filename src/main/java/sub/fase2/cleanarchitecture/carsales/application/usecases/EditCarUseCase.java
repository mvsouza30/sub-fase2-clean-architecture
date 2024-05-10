package sub.fase2.cleanarchitecture.carsales.application.usecases;

import sub.fase2.cleanarchitecture.carsales.application.gateways.CarGateway;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;

public class EditCarUseCase {
    private CarGateway carGateway;

    public EditCarUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }

    public Car editCar(Long carId, Car updatedCar){
        Car existingCar = carGateway.getCarById(carId);
        if (existingCar == null) {
            return null;
        }

        return carGateway.editCar(carId, updatedCar);

    }
}
