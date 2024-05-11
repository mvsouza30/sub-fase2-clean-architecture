package sub.fase2.cleanarchitecture.carsales.application.gateways;

import sub.fase2.cleanarchitecture.carsales.domain.entity.Sell;

public interface SellCarGateway {
    Sell sellCar(Sell sell);
}
