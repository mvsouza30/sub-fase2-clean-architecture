package sub.fase2.cleanarchitecture.carsales.application.usecases;

import sub.fase2.cleanarchitecture.carsales.application.gateways.CarGateway;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Car;
import sub.fase2.cleanarchitecture.carsales.domain.entity.Sale;
import sub.fase2.cleanarchitecture.carsales.domain.entity.valueobject.DateTimeProvider;

public class SellCarUseCase {
    private final CarGateway carGateway;
    private final DateTimeProvider dateTimeProvider;

    public SellCarUseCase(CarGateway carGateway, DateTimeProvider dateTimeProvider) {
        this.carGateway = carGateway;
        this.dateTimeProvider = dateTimeProvider;
    }

    public Sale sellCar(String cpf, Long carId, String paymentMethod, int numberOfInstallments) {
        Car car = carGateway.getCarById(carId);
        if (car == null) {
            return null;
        }

        double totalPrice = car.preco();
        double entry = 0;
        double remainingAmount = totalPrice;

        if ("financing".equals(paymentMethod)) {
            entry = totalPrice * 0.3;
            remainingAmount -= entry;
            remainingAmount += remainingAmount * 0.2;
        }

        String saleDate = dateTimeProvider.currentDateTime();
        return new Sale(cpf, carId, saleDate, paymentMethod, entry, remainingAmount, numberOfInstallments);
    }
}
