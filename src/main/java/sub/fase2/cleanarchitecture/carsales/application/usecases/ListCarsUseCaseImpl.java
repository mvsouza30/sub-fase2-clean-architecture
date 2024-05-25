package sub.fase2.cleanarchitecture.carsales.application.usecases;

import sub.fase2.cleanarchitecture.carsales.application.contracts.CarCollection;
import sub.fase2.cleanarchitecture.carsales.application.gateways.CarGateway;

public class ListCarsUseCaseImpl {
    private final CarGateway carGateway;

    public ListCarsUseCaseImpl(CarGateway carGateway) {
        this.carGateway = carGateway;
    }

    public CarCollection listCars() {
        return carGateway.getAllCarsOrderedByPrice();
    }
}
